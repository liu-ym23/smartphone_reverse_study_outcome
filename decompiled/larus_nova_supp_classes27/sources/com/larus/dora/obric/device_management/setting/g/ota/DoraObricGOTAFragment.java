package com.larus.dora.obric.device_management.setting.g.ota;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.ota.DoraOTACheckFrom;
import com.larus.dora.impl.ota.g.DoraGOTAViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.button.OProgressButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 ¾\u00012\u00020\u0001:\u0002¾\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020%2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010O\u001a\u00020MH\u0016J\b\u0010P\u001a\u00020MH\u0016J\b\u0010Q\u001a\u00020MH\u0016J\b\u0010R\u001a\u00020\u000bH\u0016J\b\u0010S\u001a\u00020%H\u0002J\b\u0010T\u001a\u00020%H\u0002J\b\u0010U\u001a\u00020%H\u0002J\b\u0010V\u001a\u00020%H\u0002J\b\u0010W\u001a\u00020%H\u0002J\b\u0010X\u001a\u00020!H\u0002J\b\u0010Y\u001a\u00020!H\u0002J\b\u0010Z\u001a\u00020%H\u0002J\b\u0010[\u001a\u00020%H\u0002J\b\u0010\\\u001a\u00020%H\u0002J\b\u0010]\u001a\u00020%H\u0002J\b\u0010^\u001a\u00020MH\u0002J\b\u0010_\u001a\u00020MH\u0002J\b\u0010`\u001a\u00020MH\u0002J\b\u0010a\u001a\u00020MH\u0002J\u0010\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u00020DH\u0002J\b\u0010d\u001a\u00020DH\u0002J\u0010\u0010e\u001a\u00020M2\u0006\u0010f\u001a\u00020DH\u0002J\b\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020M2\u0006\u0010c\u001a\u00020DH\u0002J\b\u0010j\u001a\u00020MH\u0002J\b\u0010k\u001a\u00020MH\u0002J\u0010\u0010l\u001a\u00020M2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0002J\u0018\u0010s\u001a\u00020M2\u0006\u0010p\u001a\u00020q2\u0006\u0010t\u001a\u00020hH\u0003J\u0010\u0010u\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0002J\u0018\u0010v\u001a\u00020M2\u0006\u0010p\u001a\u00020q2\u0006\u0010w\u001a\u00020hH\u0003J\u0010\u0010x\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010y\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0003J\u0012\u0010z\u001a\u00020M2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\u0016\u0010}\u001a\u00020M*\u0002012\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J+\u0010~\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u000b2\u0007\u0010\u0080\u0001\u001a\u00020D2\u0010\u0010\u0081\u0001\u001a\u000b\u0012\u0004\u0012\u00020M\u0018\u00010\u0082\u0001H\u0002J\u001b\u0010\u0083\u0001\u001a\u00020M2\u0007\u0010\u007f\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020M2\u0007\u0010\u0087\u0001\u001a\u00020\u000bH\u0002J\u000e\u0010\u0088\u0001\u001a\u00030\u0089\u0001*\u00020+H\u0002J\t\u0010\u008a\u0001\u001a\u00020MH\u0002J8\u0010\u008b\u0001\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020D2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\u008d\u0001\u001a\u000b\u0012\u0004\u0012\u00020M\u0018\u00010\u0082\u0001H\u0002J%\u0010\u008e\u0001\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u000b2\u0007\u0010\u008f\u0001\u001a\u00020h2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010\u0090\u0001\u001a\u00020MH\u0002J\u0014\u0010\u0091\u0001\u001a\u00020M2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020M2\u0007\u0010\u0093\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0094\u0001\u001a\u00020M2\u0007\u0010\u0095\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020\u000b2\u0007\u0010\u0097\u0001\u001a\u00020hH\u0003JD\u0010\u0098\u0001\u001a\u0002092\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u009d\u0001\u001a\u00020D2\u0010\b\u0002\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020M0\u0082\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020MH\u0002J\t\u0010 \u0001\u001a\u00020MH\u0002J\t\u0010¡\u0001\u001a\u00020MH\u0002J\t\u0010¢\u0001\u001a\u00020MH\u0002J\t\u0010£\u0001\u001a\u00020MH\u0002J\t\u0010¤\u0001\u001a\u00020MH\u0002J\u0012\u0010¥\u0001\u001a\u00020M2\u0007\u0010¦\u0001\u001a\u00020qH\u0002J\t\u0010§\u0001\u001a\u00020MH\u0002J\u0011\u0010¨\u0001\u001a\u00020M2\u0006\u0010p\u001a\u00020qH\u0002J\u0012\u0010©\u0001\u001a\u00020M2\u0007\u0010ª\u0001\u001a\u00020hH\u0002J\t\u0010«\u0001\u001a\u00020MH\u0002J\t\u0010¬\u0001\u001a\u00020MH\u0002J\r\u0010\u00ad\u0001\u001a\u00020M*\u00020!H\u0002J\r\u0010®\u0001\u001a\u00020M*\u00020!H\u0002J\r\u0010¯\u0001\u001a\u00020M*\u00020!H\u0002J\r\u0010°\u0001\u001a\u00020M*\u00020!H\u0002J\r\u0010±\u0001\u001a\u00020M*\u000205H\u0002J\u0012\u0010²\u0001\u001a\u00020%2\u0007\u0010³\u0001\u001a\u00020hH\u0002J\t\u0010´\u0001\u001a\u00020hH\u0002J\t\u0010µ\u0001\u001a\u00020hH\u0002J\t\u0010¶\u0001\u001a\u00020hH\u0002J\t\u0010·\u0001\u001a\u00020hH\u0002J\t\u0010¸\u0001\u001a\u00020hH\u0002J\t\u0010¹\u0001\u001a\u00020hH\u0002J\u000e\u0010º\u0001\u001a\u00020M*\u00030\u0089\u0001H\u0002J\r\u0010»\u0001\u001a\u00020h*\u00020hH\u0002J\u000e\u0010¼\u0001\u001a\u00020h*\u00030½\u0001H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001b\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001c\u0010\u0013R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¿\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/ota/DoraObricGOTAFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel;", "getModel", "()Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel;", "model$delegate", "Lkotlin/Lazy;", "manualPageSessionId", "", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getMarkdownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdownInfo$delegate", "otaNewestVersionText", "getOtaNewestVersionText", "()Ljava/lang/String;", "otaNewestVersionText$delegate", "otaFirmwareSizeText", "getOtaFirmwareSizeText", "otaFirmwareSizeText$delegate", "otaDownloadingText", "getOtaDownloadingText", "otaDownloadingText$delegate", "otaUpdatingText", "getOtaUpdatingText", "otaUpdatingText$delegate", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "autoOtaCard", "Lcom/obric/oui/lisitem/OCardListItem;", "autoOtaDescription", "Lcom/obric/oui/text/OTextView;", "autoOtaSpacer", "Landroid/view/View;", "autoOtaSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "stateContainer", "Landroid/widget/LinearLayout;", "loadingPageStatus", "Lcom/obric/oui/status/OPageStatus;", "stateTextView", "updateContentCard", "versionTextView", "sizeTextView", "notesTextView", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "bottomActionContainer", "bottomTipTextView", "actionButton", "Lcom/obric/oui/button/OButton;", "progressButton", "Lcom/obric/oui/button/OProgressButton;", "vpnConnectedDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "peripheralsLowBatteryDialog", "peripheralsOTAFailedRequireRebootDialog", "peripheralsDisconnectedDialog", "peripheralsSpaceNotEnoughDialog", "phoneSpaceNotEnoughDialog", "transferFailedDialog", "notExistSavedWifiDialog", "networkErrorDialog", "downloadOnNonWifiDialog", "isBackEnabled", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onPause", "onDestroyView", "getCurrentPageName", "buildContentView", "buildTitleBar", "buildBody", "buildContentColumn", "buildUpdateScrollContent", "buildAutoOtaCard", "buildUpdateContentCard", "buildUpdateHeader", "buildLoadingPageStatus", "buildStateContainer", "buildBottomActionContainer", "setupBackHandler", "observeOtaState", "observeOtaIntents", "observeAutoOtaSwitchState", "bindAutoOtaState", "isOn", "fromOTADebugPage", "setTitleBackEnabled", "enabled", "currentProductId", "", "requestAutoOtaSwitchUpdate", "showCheckUpdatingUi", "showCheckUpdateFailedUi", "showAlreadyLatestVersionUi", "device", "Lcom/larus/dora/api/ota/OTADevice;", "showCheckUpdateSuccessUi", "responseWrapper", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "showCheckingEnvironmentUi", "showDownloadingUi", "downloadProgress", "showDownloadSuccessUi", "showDataTransferringUi", "transferProgress", "showDeviceRestartingUi", "bindUpdateContentInfo", "bindReleaseNotes", "releaseNotes", "Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "setReleaseNotes", "showState", "text", "retry", "onRetry", "Lkotlin/Function0;", "showPageStatus", "", "showLoading", "showLatestVersionPageStatus", "version", "configurePageStatusText", "Landroid/widget/TextView;", "hideState", "showBottomActionButton", "tip", "onClick", "showBottomProgressButton", "progress", "hideBottomAction", "bindBottomTip", "updateAutoOtaVisible", "visible", "updateAutoOtaSwitch", "checked", "getSizeText", "actualSize", "buildErrorDialog", "context", "Landroid/content/Context;", "title", "message", "cancelOnTouchOutSide", "confirmAction", "showNotExistSavedWifiDialog", "showVpnConnectedDialog", "showPeripheralsDisconnectedDialog", "showPeripheralsLowBatteryDialog", "showPeripheralsSpaceNotEnoughDialog", "showPhoneSpaceNotEnoughDialog", "startDownload", "response", "showNetworkErrorDialog", "showDownloadOnNonWifiDialog", "showTransferFailDialog", "messageResId", "showPeripheralsOTAFailedRequireRebootDialog", "dismissDialogs", "applyAutoOtaCardStyle", "applyContainerCardStyle", "resetCardContainerMargins", "applyCardRadius", "applyBottomButtonStyle", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolveImageBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveHintTextColor", "resolveTertiaryTextColor", "applyTitleBarTextStyle", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGOTAFragment extends DoraBaseFragment {
    public static final /* synthetic */ int N = 0;
    public OButton A;
    public OProgressButton B;
    public com.obric.oui.dialog.v2.alert.c C;
    public com.obric.oui.dialog.v2.alert.c D;
    public com.obric.oui.dialog.v2.alert.c E;
    public com.obric.oui.dialog.v2.alert.c F;
    public com.obric.oui.dialog.v2.alert.c G;
    public com.obric.oui.dialog.v2.alert.c H;
    public com.obric.oui.dialog.v2.alert.c I;
    public com.obric.oui.dialog.v2.alert.c J;
    public com.obric.oui.dialog.v2.alert.c K;
    public com.obric.oui.dialog.v2.alert.c L;
    public boolean M;
    public final Lazy f;
    public final String g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public OFloatingTitleBar m;
    public OCardListItem n;
    public OTextView o;
    public View p;
    public OSwitch q;
    public LinearLayout r;
    public OPageStatus s;
    public OTextView t;
    public OCardListItem u;
    public OTextView v;
    public OTextView w;
    public MarkdownTextView x;
    public LinearLayout y;
    public OTextView z;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "firmware_update";
    }

    public final DoraGOTAViewModel ja0() {
        return (DoraGOTAViewModel) this.f.getValue();
    }

    public final void ka0() {
        LinearLayout r0 = this.y;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        OButton r1 = this.A;
        if (r1 == null) goto L8;
        r1.setOnClickListener(null);
    L8:
        OProgressButton r2 = this.B;
        if (r2 == null) goto L11;
        r2.setProgressMode(false);
    L11:
        OProgressButton r3 = this.B;
        if (r3 == null) goto L14;
        r3.setProgress(0);
    L14:
        OProgressButton r4 = this.B;
        if (r4 == null) goto L18;
        r4.setVisibility(8);
        return;
    }

    public DoraObricGOTAFragment() {
        final Function0<Fragment> r0 = new DoraObricGOTAFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGOTAViewModel.class), new DoraObricGOTAFragment$special$$inlined$viewModels$default$2(r0), new DoraObricGOTAFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = UUID.randomUUID().toString();
        this.h = LazyKt.lazy(new h(this));
        this.i = LazyKt.lazy(new i());
        this.j = LazyKt.lazy(new j());
        this.k = LazyKt.lazy(new k());
        this.l = LazyKt.lazy(new m());
        this.M = true;
    }

    public final boolean ia0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("from_ota_debug_page", false);
    }

    public final void onDestroyView() {
        ja0().onManualPageDestroyed(this.g);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        com.obric.oui.dialog.v2.alert.c r1 = this.C;
        if (r1 == null) goto L5;
        W90(r1);
    L5:
        com.obric.oui.dialog.v2.alert.c r2 = this.D;
        if (r2 == null) goto L8;
        W90(r2);
    L8:
        com.obric.oui.dialog.v2.alert.c r3 = this.E;
        if (r3 == null) goto L11;
        W90(r3);
    L11:
        com.obric.oui.dialog.v2.alert.c r4 = this.F;
        if (r4 == null) goto L14;
        W90(r4);
    L14:
        com.obric.oui.dialog.v2.alert.c r5 = this.G;
        if (r5 == null) goto L17;
        W90(r5);
    L17:
        com.obric.oui.dialog.v2.alert.c r6 = this.H;
        if (r6 == null) goto L20;
        W90(r6);
    L20:
        com.obric.oui.dialog.v2.alert.c r7 = this.I;
        if (r7 == null) goto L23;
        W90(r7);
    L23:
        com.obric.oui.dialog.v2.alert.c r8 = this.J;
        if (r8 == null) goto L26;
        W90(r8);
    L26:
        com.obric.oui.dialog.v2.alert.c r9 = this.K;
        if (r9 == null) goto L29;
        W90(r9);
    L29:
        com.obric.oui.dialog.v2.alert.c r10 = this.L;
        if (r10 == null) goto L32;
        W90(r10);
    L32:
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onPause() {
        ja0().onManualPagePaused();
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onResume() {
        super.onResume();
        ja0().onManualPageResumed(ia0(), this.g);
        ja0().loadSilentSwitchState();
    }

    public static void W90(com.obric.oui.dialog.v2.alert.c r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void X90(com.obric.oui.dialog.v2.alert.c r1) {
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

    public final void ba0(OButton r4) {
        r4.setGravity(17);
        r4.setMinHeight(ha0(56));
        r4.setAllCaps(false);
        r4.setIncludeFontPadding(false);
        r4.setTextSize(2, 17.0f);
        TextViewCompat.setLineHeight(r4, ra0(24.0f));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    }

    public final void ca0(OCardListItem r4) {
        Iterator r5 = CollectionsKt.listOf(new Drawable[]{r4.getCardContainer().getBackground(), r4.getContentContainer().getBackground()}).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Drawable r0 = (Drawable) r5.next();
        if ((r0 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r1 = (GradientDrawable) r0;
    L9:
        if (r1 == null) goto L4;
        r1.setCornerRadius(ha0(20));
        goto L4
    L8:
        r1 = null;
        goto L9
    }

    public final void da0(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        OTextView r4 = this.z;
        if (r4 == null) goto L13;
        r4.setVisibility(8);
    L13:
        OTextView r5 = this.z;
        if (r5 == null) goto L23;
        r5.setText(null);
        return;
    L23:
        return;
    L16:
        OTextView r2 = this.z;
        if (r2 == null) goto L19;
        r2.setVisibility(0);
    L19:
        OTextView r0 = this.z;
        if (r0 == null) goto L25;
        r0.setText(r3);
        return;
    L25:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void ea0(e49.a r10) {
        OPageStatus r0 = this.s;
        int r1 = 8;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        LinearLayout r2 = this.r;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        LinearLayout r3 = this.r;
        lw8.l r4 = null;
        if (r3 == null) goto L11;
        r3.setOnClickListener(null);
    L11:
        LinearLayout r5 = this.r;
        if (r5 == null) goto L14;
        r5.setClickable(false);
    L14:
        OCardListItem r6 = this.u;
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        OTAUpdatePackage r7 = e49.b.a(r10);
        if (r7 == null) goto L20;
        String r8 = r7.getVersion();
    L21:
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        OTextView r9 = this.v;
        if (r9 == null) goto L26;
        r9.setText(((String) this.i.getValue()) + r8);
    L26:
        OTAUpdatePackage r11 = e49.b.a(r10);
        if (r11 == null) goto L31;
        Integer r12 = r11.getSize();
        if (r12 == null) goto L31;
        int r13 = r12.intValue();
    L32:
        OTextView r14 = this.w;
        boolean r15 = true;
        if (r14 == null) goto L35;
        StringBuilder r16 = new StringBuilder();
        r16.append((String) this.j.getValue());
        float r17 = Math.max(0.1f, (r13 / 1024.0f) / 1024.0f);
        StringBuilder r18 = new StringBuilder();
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        r18.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r17)}, 1)));
        r18.append(" MB");
        r16.append(r18.toString());
        r14.setText(r16.toString());
    L35:
        z39.a r110 = r10.a;
        if (r110 == null) goto L38;
        OTAUpdateMeta r111 = r110.a();
    L39:
        if (r111 == null) goto L41;
        String r21 = r111.getDescDetail();
    L42:
        if (r21 != null) goto L44;
    L47:
        boolean r22 = true;
    L48:
        if (r22 == false) goto L61;
        if (r111 == null) goto L51;
        String r23 = r111.getDescText();
    L52:
        if (r23 != null) goto L54;
    L57:
        boolean r24 = true;
    L58:
        if (r24 == false) goto L61;
        boolean r25 = false;
    L62:
        if (r25 == false) goto L64;
        r1 = 0;
    L64:
        MarkdownTextView r26 = this.x;
        if (r26 == null) goto L67;
        r26.setVisibility(r1);
    L67:
        if (r25 == false) goto L89;
        MarkdownTextView r27 = this.x;
        if (r27 == null) goto L90;
        if (r111 == null) goto L72;
        String r28 = r111.getDescDetail();
    L73:
        if (r28 != null) goto L75;
    L78:
        if (r15 == true) goto L85;
        gw8.c.a.getClass();
        gw8.c r30 = gw8.c.a.b();
        if (r30 == null) goto L82;
        r4 = gw8.c.b.b(r30, r27, r28, false, (lw8.d) this.h.getValue());
    L82:
        if (r4 == null) goto L84;
        r27.setMarkdown(r4);
        return;
    L84:
        r27.setText(r111.getDescText());
        return;
    L85:
        if (r111 == null) goto L87;
        r4 = r111.getDescText();
    L87:
        r27.setText(r4);
        return;
    L75:
        if (r28.length() == 0) goto L78;
        r15 = false;
        goto L78
    L72:
        r28 = null;
        goto L73
    L90:
        return;
    L89:
        return;
    L54:
        if (r23.length() == 0) goto L57;
        r24 = false;
        goto L58
    L51:
        r23 = null;
    L61:
        r25 = true;
        goto L62
    L44:
        if (r21.length() == 0) goto L47;
        r22 = false;
        goto L48
    L41:
        r21 = null;
        goto L42
    L38:
        r111 = null;
    L31:
        r13 = 0;
        goto L32
    L20:
        r8 = null;
        goto L21
    }

    public final void ga0(OPageStatus r3) {
        OTextView r4 = r3.getLoadingResultView();
        if (r4 == null) goto L7;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.width = ha0(300);
        r4.setLayoutParams(r0);
        r4.setGravity(17);
        r4.setTextAlignment(4);
        r4.setBreakStrategy(0);
        r4.setHyphenationFrequency(0);
        r4.setMaxLines(Integer.MAX_VALUE);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final int ha0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void la0(OCardListItem r3) {
        ViewGroup.LayoutParams r0 = r3.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r3.getCardContainer().setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ma0(boolean r3) {
        g49.d.d("DoraObricGOTAFragment", "setTitleBackEnabled: enabled=" + r3);
        this.M = r3;
        OFloatingTitleBar r0 = this.m;
        if (r0 == null) goto L10;
        OButtonGroup r1 = r0.getStartButtonGroup();
        if (r3 == false) goto L7;
        int r4 = 0;
    L8:
        r1.setVisibility(r4);
        return;
    L7:
        r4 = 8;
        goto L8
    }

    public final void pa0(final e49.a r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.oui.dialog.v2.alert.c r1 = this.L;
        if (r1 == null) goto L8;
        W90(r1);
    L8:
        com.obric.oui.dialog.v2.alert.g r2 = new com.obric.oui.dialog.v2.alert.g(r0);
        ((com.obric.oui.dialog.base.i) r2).c = true;
        r2.w = false;
        String r3 = getString(2131902848);
        r2.j = true;
        r2.h = r3;
        com.obric.oui.dialog.v2.alert.g.c(r2);
        r2.e(getString(2131902465), new n());
        r2.h(getString(2131902467), new o(this, r4));
        com.obric.oui.dialog.v2.alert.c r5 = r2.a();
        this.L = r5;
        X90(r5);
    }

    public final int ra0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final void Y90(DoraObricGOTAFragment r14, d49.b r15) {
        r14.ma0(true);
        r14.ka0();
        OCardListItem r1 = r14.u;
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        String r16 = "v" + CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r15.a, r15.b}), "-", null, null, 0, null, new com.larus.dora.obric.device_management.setting.g.ota.a(), 30, null);
        OPageStatus r2 = r14.s;
        if (r2 == null) goto L18;
        r2.setVisibility(0);
        r2.setType(1);
        r14.ga0(r2);
        StringBuilder r3 = new StringBuilder("\u2060");
        int r5 = 0;
    L9:
        if (r5 >= r16.length()) goto L17;
        char r6 = r16.charAt(r5);
        r3.append(r6);
        if (r6 != '-') goto L13;
    L15:
        r3.append(8203);
    L16:
        r5 = r5 + 1;
        goto L9
    L13:
        if (r6 == '.') goto L15;
    L17:
        r2.setLoadingResult(r14.getString(2131903821, new Object[]{r3.toString()}));
        r2.b(false);
    L18:
        LinearLayout r17 = r14.r;
        if (r17 == null) goto L25;
        r17.setVisibility(8);
        return;
    }

    public static final void Z90(DoraObricGOTAFragment r6, int r7) {
        Context r1 = r6.getContext();
        if (r1 == null) goto L10;
        com.obric.oui.dialog.v2.alert.c r0 = r6.I;
        if (r0 == null) goto L8;
        W90(r0);
    L8:
        com.obric.oui.dialog.v2.alert.c r8 = fa0(r6, r1, r1.getString(2131902864), r1.getString(r7), null, 24);
        r6.I = r8;
        X90(r8);
        return;
    }

    public static final void aa0(DoraObricGOTAFragment r4, boolean r5) {
        OCardListItem r0 = r4.n;
        int r1 = 8;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        OTextView r2 = r4.o;
        if (r2 == null) goto L14;
        if (r5 == false) goto L12;
        int r6 = 0;
    L13:
        r2.setVisibility(r6);
        goto L14
    L12:
        r6 = 8;
    L14:
        View r7 = r4.p;
        if (r7 == null) goto L20;
        if (r5 == false) goto L18;
        r1 = 0;
    L18:
        r7.setVisibility(r1);
        return;
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        DoraGOTAViewModel r1 = ja0();
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = r2.getString("mac");
    L6:
        Bundle r4 = getArguments();
        int r5 = -1;
        if (r4 == null) goto L9;
        r5 = r4.getInt("route_param_product_id", -1);
    L9:
        r1.setTargetDeviceMac$impl_mainlandRelease(r3, r5);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L14;
        OnBackPressedDispatcher r7 = r6.getOnBackPressedDispatcher();
        if (r7 == null) goto L14;
        r7.addCallback(getViewLifecycleOwner(), new DoraObricGOTAFragment$setupBackHandler$1(this));
    L14:
        Lifecycle.State r8 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeOtaState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeOtaIntents$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeOtaIntents$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeOtaIntents$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeOtaIntents$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGOTAFragment$observeAutoOtaSwitchState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        ja0().checkUpdate(DoraOTACheckFrom.FRAGMENT_VIEW_CREATED, ia0(), this.g);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void oa0(String r3, int r4, String r5) {
        int r6 = RangesKt.coerceIn(r4, 0, 100);
        LinearLayout r1 = this.y;
        if (r1 == null) goto L5;
        r1.setVisibility(0);
    L5:
        da0(r5);
        OButton r7 = this.A;
        if (r7 == null) goto L8;
        r7.setVisibility(8);
    L8:
        OButton r8 = this.A;
        if (r8 == null) goto L11;
        r8.setOnClickListener(null);
    L11:
        OProgressButton r9 = this.B;
        if (r9 == null) goto L14;
        r9.setVisibility(0);
    L14:
        OProgressButton r10 = this.B;
        if (r10 == null) goto L17;
        r10.setEnabled(true);
    L17:
        OProgressButton r11 = this.B;
        if (r11 == null) goto L20;
        r11.setClickable(false);
    L20:
        OProgressButton r12 = this.B;
        if (r12 == null) goto L23;
        r12.setText(r3);
    L23:
        OProgressButton r13 = this.B;
        if (r13 == null) goto L26;
        r13.setProgressMode(true);
    L26:
        OProgressButton r14 = this.B;
        if (r14 == null) goto L30;
        r14.e(r6);
        return;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setCenterTitle(getString(2131902649));
        r2.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r3 = (TextView) r2.findViewById(2131365427);
        if (r3 == null) goto L5;
        r3.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r3.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r3, ra0(22.0f));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new t(this));
        this.m = r2;
        FrameLayout r7 = new FrameLayout(requireContext());
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        Context r4 = requireContext();
        LinearLayout r15 = new LinearLayout(r4);
        r15.setOrientation(1);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setPadding(ha0(12), ha0(16), ha0(12), ha0(0));
        View r10 = new OCardListItem(requireContext(), null, 6, 0);
        r10.setCardType(0);
        OCardListItem.h(r10, 0);
        r10.setShowCardBg(true);
        r10.p(false);
        r10.setTitle(getString(2131898389));
        r10.s(true);
        r10.q(false);
        r10.setDefaultCustomEndView(1);
        r10.m(true);
        r10.r(false);
        final OSwitch r9 = r10.getEndSwitch();
        if (r9 == null) goto L8;
        r9.setFocusable(false);
        r9.setOnClickListener(new d(r9, this));
    L9:
        this.q = r9;
        r10.setOnContentClickListener(new e(this));
        la0(r10);
        r10.getCardContainer().setPadding(ha0(8), ha0(8), ha0(8), ha0(8));
        r10.getContentContainer().setPadding(0, 0, ha0(4), 0);
        r10.getTitleContainer().setGravity(16);
        r10.getTitleContainer().setPadding(ha0(8), ha0(8), ha0(8), ha0(8));
        OTextView r5 = r10.getTitleView();
        r5.setGravity(8388611);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r5.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r5, ra0(22.0f));
        r5.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r10.o(false);
        ca0(r10);
        r15.addView(r10);
        this.n = r10;
        Bundle r6 = getArguments();
        if (r6 == null) goto L12;
        int r8 = r6.getInt("route_param_product_id", -1);
    L13:
        String r11 = getString(2131903621);
        int r12 = v19.c.a(2130972081, requireContext(), 2131103143);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r11, "text");
        if (o59.a.m(Integer.valueOf(r8)) == true) goto L16;
        TextView r13 = null;
    L17:
        if (r13 == null) goto L19;
        r15.addView(r13);
    L20:
        this.o = r13;
        View r14 = new View(requireContext());
        r14.setLayoutParams(new LinearLayout.LayoutParams(-1, ha0(16)));
        r15.addView(r14);
        this.p = r14;
        FrameLayout r16 = new FrameLayout(requireContext());
        r16.setClipChildren(true);
        r16.setClipToPadding(true);
        Context r20 = requireContext();
        LinearLayout r21 = new LinearLayout(r20);
        r21.setOrientation(1);
        r21.setPadding(ha0(16), ha0(16), ha0(16), ha0(16));
        Context r22 = requireContext();
        LinearLayout r111 = new LinearLayout(r22);
        r111.setOrientation(1);
        r111.setGravity(16);
        OTextView r23 = new OTextView(r22, null, 0, 14);
        r23.setIncludeFontPadding(false);
        r23.setTextColor(ContextCompat.getColor(r22, 2131104350));
        r23.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r23, ra0(22.0f));
        r23.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r23.setMaxLines(1);
        r23.setEllipsize(TextUtils.TruncateAt.END);
        r111.addView(r23, new LinearLayout.LayoutParams(-1, -2));
        this.v = r23;
        OTextView r24 = new OTextView(r22, null, 0, 14);
        r24.setIncludeFontPadding(false);
        r24.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r24.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r24, ra0(20.0f));
        r24.setMaxLines(1);
        r24.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-1, -2);
        r112.topMargin = ha0(4);
        Unit r25 = Unit.INSTANCE;
        r111.addView(r24, r112);
        this.w = r24;
        r21.addView(r111, new LinearLayout.LayoutParams(-1, -2));
        MarkdownTextView r26 = new MarkdownTextView(r20, null, 6, 0);
        r26.setIncludeFontPadding(false);
        r26.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r26.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r26, ra0(20.0f));
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(-1, -2);
        r27.topMargin = ha0(24);
        r21.addView(r26, r27);
        this.x = r26;
        NestedScrollView r28 = new NestedScrollView(r20);
        r28.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r28.setClipChildren(true);
        r28.setClipToPadding(true);
        r28.setOverScrollMode(2);
        r28.setFillViewport(false);
        r28.addView(r21, new ViewGroup.LayoutParams(-1, -2));
        OCardListItem r30 = new OCardListItem(r20, null, 6, 0);
        r30.setCardType(2);
        OCardListItem.h(r30, 0);
        r30.setShowCardBg(true);
        r30.setCustomStartView(r28);
        r30.n(true);
        r30.m(false);
        r30.r(false);
        r30.o(false);
        r30.setClipChildren(true);
        r30.setClipToPadding(true);
        la0(r30);
        r30.getCardContainer().setPadding(0, 0, 0, 0);
        r30.getContentContainer().setPadding(0, 0, 0, 0);
        Iterator r31 = CollectionsKt.listOfNotNull(new View[]{r30.getCardRoot(), r30.getCardContainer(), r30.findViewById(2131387816), r30.findViewById(2131387828), r30.getContentContainer(), r30.findViewById(2131368463)}).iterator();
    L22:
        if (r31.hasNext() == false) goto L29;
        View r32 = (View) r31.next();
        if ((r32 instanceof ViewGroup) == false) goto L26;
        ViewGroup r33 = (ViewGroup) r32;
    L27:
        if (r33 == null) goto L22;
        r33.setClipChildren(true);
        r33.setClipToPadding(true);
        goto L22
    L26:
        r33 = null;
        goto L27
    L29:
        r30.o(false);
        ca0(r30);
        r30.setVisibility(8);
        FrameLayout.LayoutParams r34 = new FrameLayout.LayoutParams(-1, -2);
        r34.bottomMargin = ha0(16);
        Unit r35 = Unit.INSTANCE;
        r16.addView(r30, r34);
        this.u = r30;
        r15.addView(r16, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        Context r36 = requireContext();
        LinearLayout r37 = new LinearLayout(r36);
        r37.setOrientation(1);
        r37.setClipChildren(false);
        r37.setClipToPadding(false);
        r37.setVisibility(8);
        r37.setPadding(0, ha0(12), 0, ha0(16));
        OTextView r38 = new OTextView(r36, null, 0, 14);
        r38.setGravity(17);
        r38.setIncludeFontPadding(false);
        r38.setTextColor(v19.c.a(2130972080, requireContext(), 2131103140));
        r38.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(r38, ra0(21.0f));
        r38.setVisibility(8);
        LinearLayout.LayoutParams r40 = new LinearLayout.LayoutParams(-1, -2);
        r40.bottomMargin = ha0(18);
        r37.addView(r38, r40);
        this.z = r38;
        View r41 = (OButton) vma.e.a(r36, 2131952832, new l());
        ba0(r41);
        r37.addView(r41, new LinearLayout.LayoutParams(-1, ha0(56)));
        this.A = r41;
        OProgressButton r42 = vma.e.a(r36, 2131953067, new r());
        ba0(r42);
        r42.setVisibility(8);
        r37.addView(r42, new LinearLayout.LayoutParams(-1, ha0(56)));
        this.B = r42;
        this.y = r37;
        r15.addView(r37, new LinearLayout.LayoutParams(-1, -2));
        r7.addView(r15, new FrameLayout.LayoutParams(-1, -1));
        OPageStatus r43 = new OPageStatus(requireContext(), null, 6, 0);
        r43.setVisibility(8);
        r43.setType(1);
        this.s = r43;
        r7.addView(r43, new FrameLayout.LayoutParams(ha0(300), -2, 17));
        Context r44 = requireContext();
        LinearLayout r45 = new LinearLayout(r44);
        r45.setOrientation(1);
        r45.setGravity(1);
        r45.setVisibility(8);
        FrameLayout r46 = new FrameLayout(r44);
        ImageView r47 = new ImageView(r44);
        r47.setImageResource(2131240637);
        r46.addView(r47, new FrameLayout.LayoutParams(ha0(60), ha0(60), 17));
        r45.addView(r46, new LinearLayout.LayoutParams(ha0(60), ha0(60)));
        OTextView r48 = new OTextView(r44, null, 0, 14);
        r48.setIncludeFontPadding(false);
        r48.setGravity(17);
        r48.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r48.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r48, ra0(20.0f));
        r45.addView(r48, new LinearLayout.LayoutParams(-2, -2));
        this.t = r48;
        this.r = r45;
        r7.addView(r45, new FrameLayout.LayoutParams(-2, -2, 17));
        return com.larus.dora.obric.utils.c.c(r1, r2, r7, v19.c.a(2130970531, requireContext(), 2131102535), null);
    L19:
        r13 = null;
        goto L20
    L16:
        r13 = new OTextView(r4, null, 0, 14);
        r13.setText(r11);
        r13.setGravity(8388611);
        r13.setTextColor(r12);
        r13.setTextSize(2, 12.0f);
        r13.setIncludeFontPadding(false);
        Resources r50 = r4.getResources();
        TextViewCompat.setLineHeight(r13, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r50, r50.getDisplayMetrics())));
        r13.setPadding(f0.a(20, r4), f0.a(8, r4), f0.a(20, r4), f0.a(8, r4));
        goto L17
    L12:
        r8 = -1;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    public final void qa0(String r5, boolean r6, final y r7) {
        int r0 = 0;
        if (r6 == false) goto L7;
        OPageStatus r2 = this.s;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        LinearLayout r3 = this.r;
        if (r3 == null) goto L19;
        if (r6 == true) goto L18;
        r0 = 8;
    L18:
        r3.setVisibility(r0);
    L19:
        OTextView r1 = this.t;
        if (r1 == null) goto L22;
        r1.setText(r5);
    L22:
        LinearLayout r8 = this.r;
        if (r8 == null) goto L25;
        r8.setClickable(r6);
    L25:
        if (r6 == false) goto L30;
        if (r7 == null) goto L30;
        LinearLayout r9 = this.r;
        if (r9 == null) goto L34;
        e1.d(r9, new p(r7));
        return;
    L34:
        return;
    L30:
        LinearLayout r10 = this.r;
        if (r10 == null) goto L36;
        r10.setOnClickListener(null);
        return;
    L36:
        return;
    L7:
        OPageStatus r4 = this.s;
        if (r4 == null) goto L10;
        r4.setVisibility(0);
        r4.setType(1);
        ga0(r4);
        r4.setLoadingResult(r5);
        r4.b(true);
    L10:
        LinearLayout r11 = this.r;
        if (r11 == null) goto L13;
        r11.setVisibility(8);
        goto L13
    }

    public final void na0(String r3, boolean r4, String r5, final Function0<Unit> r6) {
        LinearLayout r0 = this.y;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        da0(r5);
        OProgressButton r7 = this.B;
        if (r7 == null) goto L8;
        r7.setProgressMode(false);
    L8:
        OProgressButton r8 = this.B;
        if (r8 == null) goto L11;
        r8.setProgress(0);
    L11:
        OProgressButton r9 = this.B;
        if (r9 == null) goto L14;
        r9.setVisibility(8);
    L14:
        OButton r10 = this.A;
        if (r10 == null) goto L17;
        r10.setVisibility(0);
    L17:
        OButton r11 = this.A;
        if (r11 == null) goto L20;
        r11.setEnabled(r4);
    L20:
        OButton r12 = this.A;
        if (r12 == null) goto L23;
        r12.setText(r3);
    L23:
        if (r4 == false) goto L28;
        if (r6 == null) goto L28;
        OButton r13 = this.A;
        if (r13 == null) goto L32;
        e1.d(r13, new g(r6));
        return;
    L32:
        return;
    L28:
        OButton r14 = this.A;
        if (r14 == null) goto L34;
        r14.setOnClickListener(null);
        return;
    }

    public static com.obric.oui.dialog.v2.alert.c fa0(DoraObricGOTAFragment r3, Context r4, String r5, String r6, x r7, int r8) {
        if ((r8 & 4) == 0) goto L5;
        r6 = "";
    L5:
        boolean r1 = true;
        if ((r8 & 8) == 0) goto L8;
        boolean r0 = true;
    L9:
        final Function0 r9 = r7;
        if ((r8 & 16) == 0) goto L12;
        r9 = new s();
    L12:
        r3.getClass();
        com.obric.oui.dialog.v2.alert.g r10 = new com.obric.oui.dialog.v2.alert.g(r4);
        ((com.obric.oui.dialog.base.i) r10).c = r0;
        r10.w = false;
        if (r6.length() != 0) goto L15;
        boolean r11 = true;
    L16:
        r10.j = r11;
        r10.h = r5;
        if (r6.length() > 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L23;
        r6 = null;
    L23:
        r10.i = r6;
        r10.h(r3.getString(2131902851), new q(r9));
        return r10.a();
    L15:
        r11 = false;
        goto L16
    L8:
        r0 = false;
        goto L9
    }
}
