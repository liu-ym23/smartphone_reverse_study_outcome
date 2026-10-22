package com.larus.dora.impl.device.settings.lab;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.databinding.LarusDoraPageLabSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.b0;
import com.larus.settings.value.bq;
import com.larus.settings.value.e10;
import com.larus.settings.value.lc;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0007H\u0002J6\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0002J\u001e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*H\u0002J\f\u00103\u001a\u00020**\u000204H\u0002J\u0010\u00105\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u000201H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006:"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/LabSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageLabSettingsBinding;", "isVideoStreamSelectorEnabled", "", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleEnvState", "state", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings$Success;", "onResume", "forceUpdate", "currentProductId", "", "updateQuickContinuousConversationSwitch", "isEnabled", "updateAllowDoubaoViewImagesSwitch", "updateRTCTransportMode", "bluetoothRTCEnable", "p2pRTCEnable", "isP2PRTCRuntimeSupported", "isUserSelectMode", "selectableModes", "", "Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "updateVideoStreamSelectorEnabled", "enabled", "showRTCTransportModeDialog", "currentMode", "modes", "getRTCTransportModeText", "", "mode", "toRTCTransportMode", "Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "updateBehaviorAwareSwitch", "onDestroyView", "getCurrentPageName", "getPageMaskView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LabSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageLabSettingsBinding f;
    public boolean g;
    public final Lazy h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RTCTransportMode.values().length];
            r0[RTCTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[RTCTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[RTCTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[DoraXLinkTransportMode.values().length];
            r1[DoraXLinkTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[DoraXLinkTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[DoraXLinkTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ LabSettingsFragment a;

        public c(LabSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r13, Continuation r14) {
            com.larus.dora.impl.device.settings.lab.c r15 = (com.larus.dora.impl.device.settings.lab.c) r13;
            if ((r15 instanceof com.larus.dora.impl.device.settings.lab.c.a) == true) goto L267;
            if ((r15 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L265;
            final LabSettingsFragment r16 = this.a;
            com.larus.dora.impl.device.settings.lab.c.b r17 = (com.larus.dora.impl.device.settings.lab.c.b) r15;
            int r0 = LabSettingsFragment.i;
            d59.f r1 = r16.Y90().getFeatureConfig();
            View.OnClickListener r2 = null;
            if (r1 == null) goto L9;
            Map<String, d59.i> r3 = r1.a();
        L10:
            e10 r4 = e10.a;
            int r5 = l0.a;
            Boolean r6 = Boolean.FALSE;
            boolean r7 = ((Boolean) l0.a(r6, new lc())).booleanValue();
            if (r17.r == false) goto L16;
            if (r7 == false) goto L16;
            if (((Boolean) l0.a(Boolean.TRUE, new bq())).booleanValue() == true) goto L16;
            boolean r8 = true;
        L18:
            if (r17.s == false) goto L21;
            if (r7 == false) goto L21;
            boolean r9 = true;
        L22:
            g49.d.d("LabSettingsFragment", "handle env state, isSup: " + r17.a + ", envAuthEnable: " + r17.d + ", aiProactiveEntranceEnabled=" + r7 + ", showHeadControlEntrance=" + r8 + ", showBehaviorAwareEntrance=" + r9);
            if (r17.a == false) goto L31;
            if (r3 != null) goto L26;
        L28:
            boolean r10 = false;
        L29:
            if (r10 == false) goto L31;
            boolean r11 = true;
        L32:
            LarusDoraPageLabSettingsBinding r12 = r16.f;
            if (r12 == null) goto L47;
            ItemGroup r18 = r12.q;
            if (r18 == null) goto L47;
            if (r17.a == false) goto L45;
            if (r3 != null) goto L40;
        L42:
            boolean r110 = false;
        L43:
            if (r110 == false) goto L45;
            boolean r111 = true;
        L46:
            e1.y(r18, r111);
            goto L47
        L40:
            if (r3.containsKey("environmental_observation") != true) goto L42;
            r110 = true;
        L45:
            r111 = false;
        L47:
            LarusDoraPageLabSettingsBinding r20 = r16.f;
            if (r20 == null) goto L62;
            AppCompatTextView r21 = r20.p;
            if (r21 == null) goto L62;
            if (r17.a == false) goto L60;
            if (r3 != null) goto L55;
        L57:
            boolean r112 = false;
        L58:
            if (r112 == false) goto L60;
            boolean r113 = true;
        L61:
            e1.y(r21, r113);
            goto L62
        L55:
            if (r3.containsKey("environmental_observation") != true) goto L57;
            r112 = true;
        L60:
            r113 = false;
        L62:
            LarusDoraPageLabSettingsBinding r22 = r16.f;
            if (r22 == null) goto L67;
            ItemGroup r23 = r22.k;
            if (r23 == null) goto L67;
            e1.y(r23, r11);
        L67:
            LarusDoraPageLabSettingsBinding r24 = r16.f;
            if (r24 == null) goto L82;
            ItemGroup r25 = r24.m;
            if (r25 == null) goto L82;
            if (r17.a == false) goto L80;
            if (r3 != null) goto L75;
        L77:
            boolean r26 = false;
        L78:
            if (r26 == false) goto L80;
            boolean r27 = true;
        L81:
            e1.y(r25, r27);
            goto L82
        L75:
            if (r3.containsKey("memory_data") != true) goto L77;
            r26 = true;
        L80:
            r27 = false;
        L82:
            LarusDoraPageLabSettingsBinding r28 = r16.f;
            if (r28 == null) goto L97;
            ItemGroup r30 = r28.z;
            if (r30 == null) goto L97;
            if (r17.e == false) goto L95;
            if (r3 != null) goto L90;
        L92:
            boolean r31 = false;
        L93:
            if (r31 == false) goto L95;
            boolean r32 = true;
        L96:
            e1.y(r30, r32);
            goto L97
        L90:
            if (r3.containsKey("simultaneous_interpretation") != true) goto L92;
            r31 = true;
        L95:
            r32 = false;
        L97:
            LarusDoraPageLabSettingsBinding r33 = r16.f;
            if (r33 == null) goto L102;
            ItemGroup r34 = r33.s;
            if (r34 == null) goto L102;
            e1.y(r34, r8);
        L102:
            LarusDoraPageLabSettingsBinding r35 = r16.f;
            if (r35 == null) goto L107;
            ItemGroup r36 = r35.c;
            if (r36 == null) goto L107;
            e1.y(r36, r9);
        L107:
            LarusDoraPageLabSettingsBinding r37 = r16.f;
            if (r37 == null) goto L112;
            AppCompatTextView r38 = r37.e;
            if (r38 == null) goto L112;
            e1.y(r38, r9);
        L112:
            LarusDoraPageLabSettingsBinding r40 = r16.f;
            if (r40 == null) goto L117;
            ItemGroup r41 = r40.x;
            if (r41 == null) goto L117;
            e1.y(r41, r17.l);
        L117:
            LarusDoraPageLabSettingsBinding r42 = r16.f;
            if (r42 == null) goto L122;
            AppCompatTextView r43 = r42.y;
            if (r43 == null) goto L122;
            e1.y(r43, r17.l);
        L122:
            LarusDoraPageLabSettingsBinding r44 = r16.f;
            if (r44 == null) goto L127;
            ItemGroup r45 = r44.f;
            if (r45 == null) goto L127;
            e1.y(r45, ((Boolean) l0.a(r6, new lc())).booleanValue());
        L127:
            com.larus.dora.impl.core.settingsconfig.c.a.getClass();
            if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L130;
        L132:
            boolean r46 = false;
        L133:
            boolean r47 = com.larus.dora.impl.core.settingsconfig.c.b().b.contains("p2p");
            if (r46 == false) goto L139;
            if (r47 == false) goto L139;
            if (r17.q == false) goto L139;
            boolean r48 = true;
        L140:
            g49.d.d("LabSettingsFragment", "handleEnvState RTC transport: showRTCTransport=" + r46 + ", showP2PRTC=" + r48 + ", p2pAllowed=" + r47 + ", p2pAbilitySupported=" + r17.q + ", p2pRuntimeSupported=" + r17.p);
            LarusDoraPageLabSettingsBinding r50 = r16.f;
            if (r50 == null) goto L145;
            ItemGroup r51 = r50.h;
            if (r51 == null) goto L145;
            e1.y(r51, r46);
        L145:
            LarusDoraPageLabSettingsBinding r52 = r16.f;
            if (r52 == null) goto L150;
            AppCompatTextView r53 = r52.j;
            if (r53 == null) goto L150;
            e1.y(r53, r46);
        L150:
            LarusDoraPageLabSettingsBinding r54 = r16.f;
            if (r54 == null) goto L155;
            ItemTextArrow r55 = r54.o;
            if (r55 == null) goto L155;
            r55.setVisibility(8);
        L155:
            LarusDoraPageLabSettingsBinding r56 = r16.f;
            if (r56 == null) goto L162;
            ItemTextToggle r57 = r56.w;
            if (r57 == null) goto L162;
            CustomSwitchCompat r58 = r57.getToggleView();
            if (r58 == null) goto L162;
            r58.setChecked(r17.k);
        L162:
            LarusDoraPageLabSettingsBinding r60 = r16.f;
            if (r60 == null) goto L169;
            ItemTextToggle r61 = r60.w;
            if (r61 == null) goto L169;
            CustomSwitchCompat r62 = r61.getToggleView();
            if (r62 == null) goto L169;
            r62.setOnCheckedChangeListener(new j(r16));
        L169:
            LarusDoraPageLabSettingsBinding r63 = r16.f;
            if (r63 == null) goto L174;
            ItemTextArrow r64 = r63.l;
            if (r64 == null) goto L174;
            r64.setOnClickListener(new k(r16));
        L174:
            LarusDoraPageLabSettingsBinding r65 = r16.f;
            if (r65 == null) goto L179;
            ItemTextArrow r66 = r65.n;
            if (r66 == null) goto L179;
            r66.setOnClickListener(new l(r16));
        L179:
            LarusDoraPageLabSettingsBinding r67 = r16.f;
            if (r67 == null) goto L184;
            ItemTextArrow r68 = r67.A;
            if (r68 == null) goto L184;
            r68.setOnClickListener(new m(r16));
        L184:
            LarusDoraPageLabSettingsBinding r70 = r16.f;
            if (r70 == null) goto L189;
            ItemTextArrow r71 = r70.t;
            if (r71 == null) goto L189;
            r71.setOnClickListener(new n(r16));
        L189:
            LarusDoraPageLabSettingsBinding r72 = r16.f;
            if (r72 == null) goto L194;
            ItemTextArrow r73 = r72.g;
            if (r73 == null) goto L194;
            r73.setOnClickListener(new o(r16));
        L194:
            LarusDoraPageLabSettingsBinding r74 = r16.f;
            if (r74 == null) goto L205;
            ItemGroup r75 = r74.u;
            if (r75 == null) goto L205;
            if (r17.i == true) goto L201;
        L203:
            boolean r76 = false;
        L204:
            e1.y(r75, r76);
            goto L205
        L201:
            if (e10.m() == false) goto L203;
            r76 = true;
        L205:
            LarusDoraPageLabSettingsBinding r77 = r16.f;
            if (r77 == null) goto L211;
            ItemTextArrow r78 = r77.v;
            if (r78 == null) goto L211;
            r78.setOnClickListener(new p(r16));
        L211:
            if (r17.b == true) goto L218;
            LarusDoraPageLabSettingsBinding r80 = r16.f;
            if (r80 == null) goto L229;
            ItemTextArrow r81 = r80.r;
            if (r81 == null) goto L229;
            r81.getSubTextView().setText(r16.getString(2131902543));
            r81.setVisible(true);
        L229:
            LarusDoraPageLabSettingsBinding r82 = r16.f;
            if (r82 == null) goto L234;
            ItemTextArrow r83 = r82.r;
            if (r83 == null) goto L234;
            r83.setOnClickListener(new q(r16));
        L234:
            LarusDoraPageLabSettingsBinding r84 = r16.f;
            if (r84 == null) goto L248;
            if (r17.f == false) goto L245;
            if (r3 != null) goto L240;
        L242:
            boolean r85 = false;
        L243:
            if (r85 == false) goto L245;
            r84.E.setVisibility(0);
            r84.F.setVisibility(0);
            r16.ca0(r17.g);
        L246:
            e1.o(r84.B);
            e1.o(r84.C);
            goto L248
        L240:
            if (r3.containsKey("fuzzy_wakeup") != true) goto L242;
            r85 = true;
        L245:
            r84.E.setVisibility(8);
            r84.F.setVisibility(8);
        L248:
            if (r16.f == null) goto L267;
            r16.aa0(r17.j);
            boolean r86 = r17.m;
            boolean r87 = r17.n;
            boolean r88 = r17.p;
            boolean r90 = com.larus.dora.impl.core.settingsconfig.c.g();
            List r91 = com.larus.dora.impl.core.settingsconfig.c.i(r48);
            final ArrayList r92 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r91, 10));
            Iterator<T> r93 = r91.iterator();
        L251:
            if (r93.hasNext() == false) goto L253;
            r92.add(r16.Z90((DoraXLinkTransportMode) r93.next()));
            goto L251
        L253:
            com.larus.dora.impl.core.settingsconfig.c.a.getClass();
            final RTCTransportMode r94 = r16.Z90(com.larus.dora.impl.core.settingsconfig.c.d(r86, r87, r88));
            LarusDoraPageLabSettingsBinding r95 = r16.f;
            if (r95 == null) goto L263;
            ItemTextArrow r96 = r95.i;
            if (r96 == null) goto L263;
            r96.getSubTextView().setText(r16.X90(r94));
            r96.setEnabled(r16.g);
            if (r90 == true) goto L260;
        L262:
            r96.setOnClickListener(r2);
            goto L263
        L260:
            if ((!r92.isEmpty()) == false) goto L262;
            r2 = new g(r16, r94, r92);
        L263:
            r16.ba0(r17.t);
            goto L267
        L218:
            if (r17.c == false) goto L224;
            LarusDoraPageLabSettingsBinding r97 = r16.f;
            if (r97 == null) goto L229;
            ItemTextArrow r98 = r97.r;
            if (r98 == null) goto L229;
            r98.getSubTextView().setText(r16.getString(2131902545));
            r98.setVisible(true);
            goto L229
        L224:
            LarusDoraPageLabSettingsBinding r100 = r16.f;
            if (r100 == null) goto L229;
            ItemTextArrow r101 = r100.r;
            if (r101 == null) goto L229;
            r101.getSubTextView().setText(r16.getString(2131902544));
            r101.setVisible(true);
        L139:
            r48 = false;
            goto L140
        L130:
            if (r17.o == false) goto L132;
            r46 = true;
            goto L133
        L26:
            if (r3.containsKey("diary") != true) goto L28;
            r10 = true;
        L31:
            r11 = false;
        L21:
            r9 = false;
        L16:
            r8 = false;
            goto L18
        L9:
            r3 = null;
            goto L10
        L265:
            throw new NoWhenBranchMatchedException();
        L267:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ LabSettingsFragment a;

        public d(LabSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.device.settings.lab.b r5 = (com.larus.dora.impl.device.settings.lab.b) r3;
            if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.c) == false) goto L8;
            t19.s r6 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            int r7 = ((com.larus.dora.impl.device.settings.lab.b.c) r5).a;
            r6.getClass();
            t19.s.b(r1, r7, false);
            LabSettingsFragment r8 = this.a;
            int r9 = LabSettingsFragment.i;
            com.larus.dora.impl.device.settings.lab.c r10 = (com.larus.dora.impl.device.settings.lab.c) r8.Y90().getEnvStateFlow().getValue();
            if ((r10 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L21;
            this.a.ca0(((com.larus.dora.impl.device.settings.lab.c.b) r10).g);
        L21:
            return Unit.INSTANCE;
        L8:
            if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.a) == false) goto L13;
            t19.s r11 = t19.s.a;
            Application r2 = AppHost.a.getApplication();
            int r12 = ((com.larus.dora.impl.device.settings.lab.b.a) r5).a;
            r11.getClass();
            t19.s.b(r2, r12, false);
            LabSettingsFragment r13 = this.a;
            int r14 = LabSettingsFragment.i;
            com.larus.dora.impl.device.settings.lab.c r15 = (com.larus.dora.impl.device.settings.lab.c) r13.Y90().getEnvStateFlow().getValue();
            if ((r15 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L21;
            this.a.aa0(((com.larus.dora.impl.device.settings.lab.c.b) r15).j);
            goto L21
        L13:
            if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.d) == false) goto L16;
            t19.s r16 = t19.s.a;
            Application r17 = AppHost.a.getApplication();
            int r18 = ((com.larus.dora.impl.device.settings.lab.b.d) r5).a;
            r16.getClass();
            t19.s.b(r17, r18, false);
            goto L21
        L16:
            if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.C0048b) == false) goto L23;
            t19.s r20 = t19.s.a;
            Application r21 = AppHost.a.getApplication();
            int r22 = ((com.larus.dora.impl.device.settings.lab.b.C0048b) r5).a;
            r20.getClass();
            t19.s.b(r21, r22, false);
            LabSettingsFragment r23 = this.a;
            int r24 = LabSettingsFragment.i;
            com.larus.dora.impl.device.settings.lab.c r25 = (com.larus.dora.impl.device.settings.lab.c) r23.Y90().getEnvStateFlow().getValue();
            if ((r25 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L21;
            this.a.ba0(((com.larus.dora.impl.device.settings.lab.c.b) r25).t);
            goto L21
        L23:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ LabSettingsFragment a;

        public e(LabSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LabSettingsFragment r4 = this.a;
            r4.g = r3;
            LarusDoraPageLabSettingsBinding r5 = r4.f;
            if (r5 == null) goto L8;
            ItemTextArrow r6 = r5.i;
            if (r6 == null) goto L8;
            r6.setEnabled(r3);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "lab_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageLabSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.D;
    }

    public final LabSettingsViewModel Y90() {
        return (LabSettingsViewModel) this.h.getValue();
    }

    public LabSettingsFragment() {
        this.g = true;
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LabSettingsViewModel.class), new LabSettingsFragment$special$$inlined$activityViewModels$default$1(this), new LabSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final int W90() {
        Bundle r0 = getArguments();
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.getInt("product_id", -1);
    L6:
        if (r2 <= 0) goto L8;
        return r2;
    L8:
        if (r0 == null) goto L10;
        int r3 = r0.getInt("route_param_product_id", -1);
    L11:
        if (r3 <= 0) goto L13;
        return r3;
    L13:
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L18;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L18;
        r1 = r5.y();
    L18:
        if (r1 <= 0) goto L20;
        return r1;
    L20:
        return 17;
    L10:
        r3 = -1;
        goto L11
    L5:
        r2 = -1;
        goto L6
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final void onResume() {
        super.onResume();
        Y90().forceUpdateEnable();
    }

    public final String X90(RTCTransportMode r2) {
        int r3 = b.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        int r4 = 2131902605;
    L14:
        return getString(r4);
    L5:
        if (r3 != 2) goto L7;
        r4 = 2131902607;
        goto L14
    L7:
        if (r3 != 3) goto L10;
        r4 = 2131902990;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final RTCTransportMode Z90(DoraXLinkTransportMode r2) {
        int r3 = b.b[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return RTCTransportMode.WIFI;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return RTCTransportMode.BLUETOOTH;
    L13:
        return RTCTransportMode.OFF;
    }

    public final void aa0(boolean r3) {
        LarusDoraPageLabSettingsBinding r0 = this.f;
        if (r0 == null) goto L10;
        ItemTextToggle r1 = r0.b;
        if (r1 == null) goto L11;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(new com.larus.dora.impl.device.settings.lab.d(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void ba0(boolean r3) {
        LarusDoraPageLabSettingsBinding r0 = this.f;
        if (r0 == null) goto L10;
        ItemTextToggle r1 = r0.d;
        if (r1 == null) goto L11;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(new i(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void ca0(boolean r3) {
        LarusDoraPageLabSettingsBinding r0 = this.f;
        if (r0 == null) goto L10;
        ItemTextToggle r1 = r0.G;
        if (r1 == null) goto L11;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(new com.larus.dora.impl.device.settings.lab.e(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        String r13 = ILoginService.a.getAccountInfo().c;
        if (o0.d(r13) == false) goto L5;
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "uid");
        b0.j().storeBoolean("dora_settings_first_use_lab_entry" + r13, false);
    L5:
        LarusDoraPageLabSettingsBinding r14 = this.f;
        if (r14 == null) goto L10;
        NovaTitleBarEx r0 = r14.H;
        if (r0 == null) goto L10;
        NovaTitleBarEx.Y5(r0, getString(2131903344), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new f(this), 14);
    L10:
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new LabSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new LabSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new LabSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r15, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r310, ViewGroup r40, Bundle r41) {
        Intrinsics.checkNotNullParameter(r310, "inflater");
        ConstraintLayout r0 = r310.inflate(2131562273, r40, false);
        int r1 = 2131369401;
        if (ViewBindings.findChildViewById(r0, 2131369401) == null) goto L79;
        r1 = 2131369402;
        ItemTextToggle r5 = ViewBindings.findChildViewById(r0, 2131369402);
        if (r5 == null) goto L79;
        r1 = 2131369403;
        if (ViewBindings.findChildViewById(r0, 2131369403) == null) goto L79;
        r1 = 2131369428;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369428);
        if (r6 == null) goto L79;
        r1 = 2131369429;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r0, 2131369429);
        if (r7 == null) goto L79;
        r1 = 2131369430;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r0, 2131369430);
        if (r8 == null) goto L79;
        r1 = 2131369674;
        ItemGroup r9 = ViewBindings.findChildViewById(r0, 2131369674);
        if (r9 == null) goto L79;
        r1 = 2131369675;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r0, 2131369675);
        if (r10 == null) goto L79;
        r1 = 2131369676;
        ItemGroup r11 = ViewBindings.findChildViewById(r0, 2131369676);
        if (r11 == null) goto L79;
        r1 = 2131369677;
        ItemTextArrow r12 = ViewBindings.findChildViewById(r0, 2131369677);
        if (r12 == null) goto L79;
        r1 = 2131369678;
        AppCompatTextView r13 = ViewBindings.findChildViewById(r0, 2131369678);
        if (r13 == null) goto L79;
        r1 = 2131369679;
        ItemGroup r14 = ViewBindings.findChildViewById(r0, 2131369679);
        if (r14 == null) goto L79;
        r1 = 2131369680;
        ItemTextArrow r15 = ViewBindings.findChildViewById(r0, 2131369680);
        if (r15 == null) goto L79;
        r1 = 2131369681;
        ItemGroup r16 = ViewBindings.findChildViewById(r0, 2131369681);
        if (r16 == null) goto L79;
        r1 = 2131369682;
        ItemTextArrow r17 = ViewBindings.findChildViewById(r0, 2131369682);
        if (r17 == null) goto L79;
        r1 = 2131369683;
        ItemTextArrow r18 = ViewBindings.findChildViewById(r0, 2131369683);
        if (r18 == null) goto L79;
        r1 = 2131369684;
        AppCompatTextView r110 = ViewBindings.findChildViewById(r0, 2131369684);
        if (r110 == null) goto L79;
        r1 = 2131369685;
        ItemGroup r20 = ViewBindings.findChildViewById(r0, 2131369685);
        if (r20 == null) goto L79;
        r1 = 2131369686;
        ItemTextArrow r21 = ViewBindings.findChildViewById(r0, 2131369686);
        if (r21 == null) goto L79;
        r1 = 2131369687;
        ItemGroup r22 = ViewBindings.findChildViewById(r0, 2131369687);
        if (r22 == null) goto L79;
        r1 = 2131369688;
        ItemTextArrow r23 = ViewBindings.findChildViewById(r0, 2131369688);
        if (r23 == null) goto L79;
        r1 = 2131369689;
        ItemGroup r24 = ViewBindings.findChildViewById(r0, 2131369689);
        if (r24 == null) goto L79;
        r1 = 2131369690;
        ItemTextArrow r25 = ViewBindings.findChildViewById(r0, 2131369690);
        if (r25 == null) goto L79;
        r1 = 2131369691;
        ItemTextToggle r26 = ViewBindings.findChildViewById(r0, 2131369691);
        if (r26 == null) goto L79;
        r1 = 2131369692;
        ItemGroup r27 = ViewBindings.findChildViewById(r0, 2131369692);
        if (r27 == null) goto L79;
        r1 = 2131369693;
        AppCompatTextView r28 = ViewBindings.findChildViewById(r0, 2131369693);
        if (r28 == null) goto L79;
        r1 = 2131369694;
        ItemGroup r210 = ViewBindings.findChildViewById(r0, 2131369694);
        if (r210 == null) goto L79;
        r1 = 2131369695;
        ItemTextArrow r30 = ViewBindings.findChildViewById(r0, 2131369695);
        if (r30 == null) goto L79;
        r1 = 2131369696;
        if (ViewBindings.findChildViewById(r0, 2131369696) == null) goto L79;
        r1 = 2131369697;
        ItemGroup r31 = ViewBindings.findChildViewById(r0, 2131369697);
        if (r31 == null) goto L79;
        r1 = 2131369698;
        AppCompatTextView r32 = ViewBindings.findChildViewById(r0, 2131369698);
        if (r32 == null) goto L79;
        r1 = 2131369962;
        View r33 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r33 == null) goto L79;
        r1 = 2131369986;
        ItemGroup r34 = ViewBindings.findChildViewById(r0, 2131369986);
        if (r34 == null) goto L79;
        r1 = 2131369987;
        AppCompatTextView r35 = ViewBindings.findChildViewById(r0, 2131369987);
        if (r35 == null) goto L79;
        r1 = 2131369988;
        ItemTextToggle r36 = ViewBindings.findChildViewById(r0, 2131369988);
        if (r36 == null) goto L79;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L79;
        r1 = 2131388772;
        NovaTitleBarEx r37 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r37 == null) goto L79;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageLabSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36, r37);
        return r2;
    L79:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
