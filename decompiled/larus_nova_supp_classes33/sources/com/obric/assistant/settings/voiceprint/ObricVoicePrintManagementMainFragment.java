package com.obric.assistant.settings.voiceprint;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.ObricEnrolledDeviceInfo;
import com.obric.assistant.impl.databinding.ObricFragmentVoicePrintManagementBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.settings.VoicePrintScene;
import com.obric.assistant.t1;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceTypeEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueProductIdEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0002^_B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u000f\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001dH\u0002J;\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001d04H\u0002J\b\u00108\u001a\u00020\fH\u0002J\u001e\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\"2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0<H\u0002JQ\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020\u001dH\u0002J\b\u0010F\u001a\u00020\u001dH\u0002J\b\u0010G\u001a\u00020\u001dH\u0002J&\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\fH\u0002J\u0010\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u0006H\u0002J\u0012\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\u000e\u0010S\u001a\u00020\fH\u0083@¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020L0KH\u0002J\u001d\u0010V\u001a\u0004\u0018\u00010\u001d2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020L0KH\u0002¢\u0006\u0002\u0010XJ \u0010Y\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0011H\u0002J\u0017\u0010[\u001a\u0004\u0018\u00010\u00112\u0006\u0010C\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\\J\u0017\u0010]\u001a\u0004\u0018\u00010\u00112\u0006\u0010B\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\\R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementMainFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentVoicePrintManagementBinding;", "btListenerUuid", "Ljava/util/UUID;", "updateCurrentDeviceJob", "Lkotlinx/coroutines/Job;", "lastCurrentDeviceVisible", "", "Ljava/lang/Boolean;", "lastCurrentDeviceMacId", "", "lastCurrentDeviceIconRes", "", "Ljava/lang/Integer;", "bluetoothListenersRegistered", "voicePrintMenuPopover", "Lcom/obric/oui/popover/v2/OPopover;", "isObricOS", "isAccessoryVoicePrintEntryEnabled", "autoLogEnterPage", "getCurrentPageName", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "logEnterPage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onStart", "onStop", "onDestroy", "setTopBar", "()Lkotlin/Unit;", "updateUI", "showDeleteVoicePrintConfirmDialog", "title", "message", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isUserAgreed", "isContinueSpeakNoiseReductionAvailable", "showVoicePrintMenu", "anchor", "onDeleteClick", "Lkotlin/Function0;", "startVoicePrintEnroll", "forResult", "macHash", "enrollDeviceType", "deviceName", "blueDeviceType", "blueProductId", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "registerBluetoothListeners", "unregisterBluetoothListeners", "requestUpdateCurrentDeviceUI", "updateAccessoryVoicePrintGuideUI", "isConnected", "recordedAccessories", "", "Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementMainFragment$AccessoryVoicePrint;", "isVoicePrintExisted", "hideCurrentDevice", "vb", "isDoraGWearOnDevice", "device", "Landroid/bluetooth/BluetoothDevice;", "updateCurrentDeviceUI", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordedAccessories", "renderAccessoryList", "list", "(Ljava/util/List;)Lkotlin/Unit;", "resolveAccessoryIconRes", "fallbackRes", "resolveAccessoryProductIconRes", "(I)Ljava/lang/Integer;", "resolveAccessoryDeviceTypeIconRes", "Companion", "AccessoryVoicePrint", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoicePrintManagementMainFragment extends TraceFragment implements com.obric.assistant.settings.t {
    public static final CoroutineScope l = null;
    public ObricFragmentVoicePrintManagementBinding e;
    public final UUID f;
    public Boolean g;
    public String h;
    public boolean i;
    public com.obric.oui.popover.v2.c j;
    public final boolean k;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "AccessoryVoicePrint(macHash=" + this.a + ", displayName=" + this.b + ", blueDeviceType=" + this.c + ", blueProductId=" + this.d + ')';
        }

        public a(String r2, String r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "macHash");
            Intrinsics.checkNotNullParameter(r3, "displayName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BlueProductIdEnum.values().length];
            r0[BlueProductIdEnum.GLASS_DORA_G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L94:
            r0[BlueProductIdEnum.HEADSET_OLA_FRIEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L106:
            r0[BlueProductIdEnum.HEADSET_HW_FREEBUDS_PRO5_1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L114:
            r0[BlueProductIdEnum.HEADSET_HW_FREEBUDS_PRO5_2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L116:
            r0[BlueProductIdEnum.HEADSET_HW_FREECLIP2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L124:
            r0[BlueProductIdEnum.GLASS_DORA_G2.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L134:
            r0[BlueProductIdEnum.TYPE_UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L50
        L16:
            a = r0;
            int[] r1 = new int[BlueDeviceTypeEnum.values().length];
            r1[BlueDeviceTypeEnum.TYPE_HEADSET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L51
        L92:
            r1[BlueDeviceTypeEnum.TYPE_CARKIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L52
        L102:
            r1[BlueDeviceTypeEnum.TYPE_LOUDSPEAKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L53
        L110:
            r1[BlueDeviceTypeEnum.TYPE_WATCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L54
        L120:
            r1[BlueDeviceTypeEnum.TYPE_BAND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L55
        L128:
            r1[BlueDeviceTypeEnum.TYPE_COMPUTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L56
        L136:
            r1[BlueDeviceTypeEnum.TYPE_SMART_PHONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L57
        L86:
            r1[BlueDeviceTypeEnum.TYPE_KEYBOARD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L58
        L96:
            r1[BlueDeviceTypeEnum.TYPE_MOUSE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L59
        L98:
            r1[BlueDeviceTypeEnum.TYPE_PERIPHERAL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L60
        L108:
            r1[BlueDeviceTypeEnum.TYPE_EBIKE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L61
        L130:
            r1[BlueDeviceTypeEnum.TYPE_GLASS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L62
        L138:
            r1[BlueDeviceTypeEnum.TYPE_PAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L63
        L76:
            r1[BlueDeviceTypeEnum.TYPE_LAPTOP.ordinal()] = 14;     // Catch: NoSuchFieldError -> L64
        L80:
            r1[BlueDeviceTypeEnum.TYPE_MICROPHONE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L65
        L104:
            r1[BlueDeviceTypeEnum.TYPE_TV.ordinal()] = 16;     // Catch: NoSuchFieldError -> L66
        L112:
            r1[BlueDeviceTypeEnum.TYPE_HEADPHONES.ordinal()] = 17;     // Catch: NoSuchFieldError -> L67
        L118:
            r1[BlueDeviceTypeEnum.TYPE_GAMEPAD.ordinal()] = 18;     // Catch: NoSuchFieldError -> L68
        L126:
            r1[BlueDeviceTypeEnum.TYPE_VR.ordinal()] = 19;     // Catch: NoSuchFieldError -> L69
        L78:
            r1[BlueDeviceTypeEnum.TYPE_CAMERA.ordinal()] = 20;     // Catch: NoSuchFieldError -> L70
        L88:
            r1[BlueDeviceTypeEnum.TYPE_GIMBAL.ordinal()] = 21;     // Catch: NoSuchFieldError -> L71
        L90:
            r1[BlueDeviceTypeEnum.TYPE_PRINTER.ordinal()] = 22;     // Catch: NoSuchFieldError -> L72
        L100:
            r1[BlueDeviceTypeEnum.TYPE_SELFIESTICK.ordinal()] = 23;     // Catch: NoSuchFieldError -> L73
        L122:
            r1[BlueDeviceTypeEnum.TYPE_EVEHICLE.ordinal()] = 24;     // Catch: NoSuchFieldError -> L74
        L132:
            r1[BlueDeviceTypeEnum.TYPE_UNKNOWN.ordinal()] = 25;     // Catch: NoSuchFieldError -> L75
        L42:
            b = r1;
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_voiceprint_settings";
    }

    static {
        l = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final void T90() {
        CoroutineScope r0 = w.a;
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("previous_page");
        if (r2 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("dora_voiceprint_settings", "currentPage");
        Intrinsics.checkNotNullParameter(r2, "previousPage");
        BuildersKt.launch$default(w.a, null, null, new VoicePrintTrackHelper$enterPage$1("dora_voiceprint_settings", r2, null), 3, null);
        return;
    L6:
        r2 = "unknown";
        goto L7
    }

    public final void ba0() {
        if (this.i == false) goto L12;
        IBluetoothHeadSetAPI r0 = tha.c.a();
        if (r0 == null) goto L7;
        r0.k(this.f);
    L7:
        IBluetoothHeadSetAPI r1 = tha.c.a();
        if (r1 == null) goto L10;
        r1.c(this.f);
    L10:
        this.i = false;
        return;
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.k == true) goto L5;
        return null;
    L5:
        ObricFragmentVoicePrintManagementBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.i;
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.j;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.j = null;
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onStop() {
        com.obric.oui.popover.v2.c r0 = this.j;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.j = null;
        ba0();
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    public ObricVoicePrintManagementMainFragment() {
        this.f = UUID.randomUUID();
        this.k = t9a.b.a().b();
    }

    public final void ca0() {
        LifecycleOwner r0 = (LifecycleOwner) getViewLifecycleOwnerLiveData().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getMain(), null, new ObricVoicePrintManagementMainFragment$updateUI$1(this, null), 2, null);
    }

    public final void onDestroy() {
        ba0();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public static final List U90(ObricVoicePrintManagementMainFragment r6) {
        r6.getClass();
        List r7 = t1.a.m();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ObricEnrolledDeviceInfo r1 = (ObricEnrolledDeviceInfo) r8.next();
        r0.add(new a(r1.getMacId(), r1.getDeviceName(), r1.getBlueDeviceType(), r1.getBlueProductId()));
        goto L4
    L6:
        return r0;
    }

    public static final boolean W90(ObricVoicePrintManagementMainFragment r2) {
        t1 r3 = t1.a;
        if (r3.P() == true) goto L5;
    L11:
        return false;
    L5:
        if (t9a.b.a().c("obric_feature_audio_os_mic_ref_sync") == false) goto L11;
        if (r3.isObricContTalkPvadSwitchShowEnable() == false) goto L11;
        if (r3.N() == false) goto L11;
        return true;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public static final void V90(ObricVoicePrintManagementMainFragment r1, ObricFragmentVoicePrintManagementBinding r2) {
        r1.g = Boolean.FALSE;
        r1.h = null;
        r2.f.setVisibility(8);
        r2.c.removeAllViews();
    }

    public static int X90(int r2, int r3) {
        BlueProductIdEnum.Companion.getClass();
        Integer r0 = null;
        switch(c.a[BlueProductIdEnum.a.a(r3).ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        Integer r4 = null;
    L12:
        if (r4 != null) goto L45;
        BlueDeviceTypeEnum.Companion.getClass();
        switch(c.b[BlueDeviceTypeEnum.a.a(r2).ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L29;
            case 13: goto L28;
            case 14: goto L27;
            case 15: goto L26;
            case 16: goto L25;
            case 17: goto L24;
            case 18: goto L23;
            case 19: goto L22;
            case 20: goto L21;
            case 21: goto L21;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L18;
            case 25: goto L41;
            default: goto L17;
        };
    L18:
        r0 = 2131236077;
        goto L41
    L19:
        r0 = 2131236100;
        goto L41
    L20:
        r0 = 2131236101;
        goto L41
    L21:
        r0 = 2131236082;
        goto L41
    L22:
        r0 = 2131236112;
        goto L41
    L23:
        r0 = 2131236081;
        goto L41
    L24:
        r0 = 2131236084;
        goto L41
    L25:
        r0 = 2131236107;
        goto L41
    L26:
        r0 = 2131236092;
        goto L41
    L27:
        r0 = 2131236089;
        goto L41
    L28:
        r0 = 2131236096;
        goto L41
    L29:
        r0 = 2131236083;
        goto L41
    L30:
        r0 = 2131236064;
        goto L41
    L31:
        r0 = 2131236065;
        goto L41
    L32:
        r0 = 2131236094;
        goto L41
    L33:
        r0 = 2131236088;
        goto L41
    L34:
        r0 = 2131236099;
        goto L41
    L35:
        r0 = 2131236071;
        goto L41
    L36:
        r0 = 2131236117;
        goto L41
    L37:
        r0 = 2131236116;
        goto L41
    L38:
        r0 = 2131236085;
        goto L41
    L39:
        r0 = 2131236066;
        goto L41
    L40:
        r0 = 2131236075;
    L41:
        if (r0 != null) goto L46;
        return 2131236075;
    L46:
        return r0.intValue();
    L17:
        throw new NoWhenBranchMatchedException();
    L45:
        return r4.intValue();
    L7:
        r4 = 2131236072;
        goto L12
    L8:
        r4 = 2131236079;
        goto L12
    L9:
        r4 = 2131236078;
        goto L12
    L10:
        r4 = 2131236095;
        goto L12
    L11:
        r4 = 2131236083;
        goto L12
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void Z90(View r13, final Function0<Unit> r14) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        Context r1 = r13.getContext();
        com.obric.oui.popover.v2.c r2 = this.j;
        if (r2 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L8:
        Intrinsics.checkNotNull(r1);
        OPopoverEntranceMenuView.Builder r3 = new OPopoverEntranceMenuView.Builder(r1);
        r3.f(OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_STANDARD);
        int r4 = ContextCompat.getColor(r1, 2131102650);
        SpannableString r7 = new SpannableString(r1.getString(2131912579));
        r7.setSpan(new ForegroundColorSpan(r4), 0, r7.length(), 33);
        r3.b(2131236108, null, Integer.valueOf(r4), r7, null, null, false, new m(this, r14));
        OPopoverEntranceMenuView r15 = r3.e();
        com.obric.oui.popover.v2.c.a r5 = new com.obric.oui.popover.v2.c.a(r0);
        Intrinsics.checkNotNullParameter(r15, "view");
        ((com.obric.oui.popover.v2.h) r5).f = r15;
        ((com.obric.oui.popover.v2.h) r5).b = true;
        ((com.obric.oui.popover.v2.h) r5).i = true;
        ((com.obric.oui.popover.v2.h) r5).k = true;
        ((com.obric.oui.popover.v2.h) r5).l = true;
        com.obric.oui.popover.v2.c r6 = r5.a();
        this.j = r6;
        int r16 = com.obric.oui.popover.v2.i.a;
        com.obric.oui.popover.v2.i.c(r6, r13, 83, 0, false, 248);
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        ObricFragmentVoicePrintManagementBinding r14 = this.e;
        if (r14 == null) goto L10;
        if (this.k == false) goto L7;
        OFloatingTitleBar r15 = r14.i;
        r15.setVisibility(0);
        r15.setCenterTitle(getString(2131912580));
        OFloatingTitleBar.k(r15, null, 6).setOnClickListener(new e(this));
    L8:
        Unit r16 = Unit.INSTANCE;
        goto L10
    L7:
        int r17 = rda.a.a;
        NovaTitleBarEx r4 = rda.a.b(r14.i);
        r4.setVisibility(0);
        NovaTitleBarEx.Y5(r4, getString(2131912580), null, null, 6);
        NovaTitleBarEx.b6(r4, 2131241477, false, null, null, new h(this), 14);
    L10:
        if (this.k == true) goto L16;
        ObricFragmentVoicePrintManagementBinding r18 = this.e;
        if (r18 == null) goto L16;
        OTextView r19 = r18.h;
        if (r19 == null) goto L16;
        r19.setText(2131912585);
    L16:
        ca0();
    }

    public final void Y90(String r4, String r5, final Function1<? super Boolean, Unit> r6) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.oui.dialog.v2.alert.g r1 = new com.obric.oui.dialog.v2.alert.g(r0);
        r1.w = false;
        r1.j = false;
        r1.h = r4;
        r1.i = r5;
        r1.m = 0;
        r1.t = true;
        r1.e(r0.getString(2131912491), new o(r6));
        r1.h(r0.getString(2131912492), new p(r6));
        com.obric.oui.dialog.v2.alert.c r7 = r1.a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131564011, r12, false);
        int r15 = 2131362014;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131362014);
        if (r2 == null) goto L34;
        r15 = 2131367771;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131367771)) == null) goto L34;
        r15 = 2131368337;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131368337);
        if (r3 == null) goto L34;
        r15 = 2131373914;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131373914);
        if (r4 == null) goto L34;
        r15 = 2131373915;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131373915);
        if (r5 == null) goto L34;
        r15 = 2131373945;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131373945);
        if (r6 == null) goto L34;
        r15 = 2131373995;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131373995);
        if (r7 == null) goto L34;
        r15 = 2131375956;
        if (((ImageView) ViewBindings.findChildViewById(r14, 2131375956)) == null) goto L34;
        r15 = 2131390091;
        if (ViewBindings.findChildViewById(r14, 2131390091) == null) goto L34;
        r15 = 2131390092;
        if (ViewBindings.findChildViewById(r14, 2131390092) == null) goto L34;
        r15 = 2131391697;
        OTextView r8 = ViewBindings.findChildViewById(r14, 2131391697);
        if (r8 == null) goto L34;
        r15 = 2131392741;
        if (((ScrollView) ViewBindings.findChildViewById(r14, 2131392741)) == null) goto L34;
        r15 = 2131392742;
        OFloatingTitleBar r9 = ViewBindings.findChildViewById(r14, 2131392742);
        if (r9 == null) goto L34;
        FrameLayout r16 = (FrameLayout) r14;
        this.e = new ObricFragmentVoicePrintManagementBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        if (r16 == null) goto L31;
        r16.setTag(2131377847, this);
        return r16;
    L31:
        return null;
    L34:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public final void aa0(final String r13, final Integer r14, final String r15, final Integer r16, final Integer r17) {
        final FragmentActivity r8 = getActivity();
        if (r8 == null) goto L6;
        ega.c r9 = ega.c.a;
        VoicePrintScene r10 = VoicePrintScene.VOICE_WAKE_UP;
        Function0 r11 = new i(r8, r14, r13, r15, r16, r17, this);
        Function0 r0 = new j();
        r9.getClass();
        ega.c.a(r8, r10, r11, r0);
        return;
    }
}
