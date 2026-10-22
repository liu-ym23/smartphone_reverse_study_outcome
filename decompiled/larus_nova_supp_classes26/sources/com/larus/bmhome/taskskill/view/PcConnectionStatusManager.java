package com.larus.bmhome.taskskill.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.taskskill.SkillComponent$k;
import com.larus.bmhome.taskskill.l2;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.flowskill.impl.databinding.LayoutPcConnectionStatusBinding;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcConnectionStatusManager {
    public static final /* synthetic */ int k = 0;
    public final LifecycleOwner a;
    public final com.larus.bmhome.taskskill.view.c b;
    public final long c;
    public final Map<Integer, Long> d;
    public LayoutPcConnectionStatusBinding e;
    public bs8.a f;
    public long g;
    public final MutableLiveData<com.larus.bmhome.taskskill.view.b> h;
    public f i;
    public final PcConnectionStatusManager$lifecycleObserver$1 j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PcConnectionStatusAction.values().length];
            r0[PcConnectionStatusAction.RetryGetAllDevices.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PcConnectionStatusAction.RequestAuthorizedPermission.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    public final void e(com.larus.bmhome.taskskill.view.b r4) {
        FLogger.a.d("PcConnectionStatusManager", "[updateHeader] connectionStatus = " + r4);
        if (this.b.b().a() == true) goto L6;
        return;
    L6:
        if (r4 != null) goto L9;
        this.b.c("", null);
        return;
    L9:
        AppHost.Companion r1 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r1.getApplication()) == true) goto L14;
        this.b.c(r1.getApplication().getString(2131906741), null);
        return;
    L14:
        if (Intrinsics.areEqual(r4, com.larus.bmhome.taskskill.view.b.C0038b.a) == false) goto L17;
        this.b.c(b(2131241705, true), null);
        return;
    L17:
        if (Intrinsics.areEqual(r4, com.larus.bmhome.taskskill.view.b.d.a) == false) goto L20;
        com.larus.bmhome.taskskill.view.c r5 = this.b;
        r5.c(r5.a(), 2131241518);
        return;
    L20:
        if (Intrinsics.areEqual(r4, com.larus.bmhome.taskskill.view.b.a.a) == false) goto L22;
        this.b.c(b(2131241704, false), null);
        return;
    L22:
        this.b.c(b(2131241705, false), null);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.taskskill.view.PcConnectionStatusManager$lifecycleObserver$1] */
    public PcConnectionStatusManager(LifecycleOwner r2, SkillComponent$k r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
        this.d = new LinkedHashMap();
        this.c = SystemClock.elapsedRealtime();
        this.h = new MutableLiveData();
        this.j = new PcConnectionStatusManager$lifecycleObserver$1(this);
    }

    public final CharSequence b(int r16, boolean r17) {
        bs8.a r1 = this.f;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r5 = r3.toString();
        if (r17 == true) goto L12;
        String[] r6 = new String[2];
        r6[0] = r5;
        String r7 = this.b.V7();
        if (r7 == null) goto L25;
        r4 = r7;
    L25:
        r6[1] = r4;
        List r8 = CollectionsKt.listOf(r6);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L27:
        if (r10.hasNext() == false) goto L31;
        Object r11 = r10.next();
        if ((!StringsKt.isBlank((String) r11)) == false) goto L27;
        r9.add(r11);
        goto L27
    L31:
        String r12 = CollectionsKt.joinToString$default(r9, " · ", null, null, 0, null, null, 62, null);
    L32:
        ViewGroup r13 = this.b.getContainerView();
        if (r13 == null) goto L36;
        Context r14 = r13.getContext();
        if (r14 == null) goto L36;
    L37:
        int r15 = r14.getResources().getDimensionPixelSize(v19.c.b(2130971517, r14, 2131167404));
        Drawable r18 = ContextCompat.getDrawable(r14, r16);
        if (r18 != null) goto L40;
        return r12;
    L40:
        r18.setBounds(0, 0, r15 + 0, r15);
        SpannableStringBuilder r19 = new SpannableStringBuilder();
        r19.append(" ");
        r19.setSpan(new ya9.b(r18, 0), 0, 1, 33);
        r19.append(" ");
        r19.append(r12);
        return r19;
    L36:
        r14 = AppHost.a.getApplication();
        goto L37
    L12:
        if ((!StringsKt.isBlank(r5)) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        r2 = r5.concat(" · ");
    L17:
        if (r2 == null) goto L20;
        r4 = r2;
    L20:
        r12 = AppHost.a.getApplication().getString(2131906928, new Object[]{r4});
        goto L32
    L5:
        r3 = null;
        goto L6
    }

    public final void c(bs8.a r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "caller");
        FLogger r0 = FLogger.a;
        r0.i("PcConnectionStatusManager", "[updateAgentTaskParam][" + r9 + "] new agentTaskParam: " + r8 + ", old agentTaskParam: " + this.f);
        e((com.larus.bmhome.taskskill.view.b) this.h.getValue());
        if (Intrinsics.areEqual(this.f, r8) == false) goto L5;
        return;
    L5:
        this.f = r8;
        this.g++;
        this.b.g();
        r0.i("PcConnectionStatusManager", "[initConnectionStatus] current agentTaskParam: " + this.f);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new PcConnectionStatusManager$initConnectionStatus$1(this, this.g, null), 3, null);
    }

    public final void d(AllDeviceResponse r28, boolean r29) {
        bs8.a r2 = this.f;
        String r9 = "";
        String r10 = null;
        if (r2 == null) goto L70;
        Integer r3 = r2.c;
        boolean r4 = true;
        if (r3 == null) goto L11;
        if (r3.intValue() == 1) goto L70;
    L11:
        if (r28 != null) goto L16;
        if (r29 == false) goto L14;
        FLogger.a.i("PcConnectionStatusManager", "[updateConnectionStatus] device request failed, converge to not found");
        this.b.e("PcConnectionStatusManager.doWhenDeviceNotFound");
        this.h.postValue(com.larus.bmhome.taskskill.view.b.d.a);
        return;
    L14:
        FLogger.a.i("PcConnectionStatusManager", "[updateConnectionStatus] devicesInfo is null, keep pending");
        this.h.postValue(com.larus.bmhome.taskskill.view.b.C0038b.a);
        return;
    L16:
        String r13 = l2.d(r2, r28);
        String r5 = r2.e;
        int r14 = 0;
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L31;
        if (r13 != null) goto L26;
    L29:
        if (r4 == true) goto L31;
        this.f = bs8.a.a(r2, null, null, r13, null, null, 111);
        this.b.f(r13);
        goto L31
    L26:
        if (StringsKt.isBlank(r13) == true) goto L29;
        r4 = false;
    L31:
        bs8.h r7 = this.b.b();
        bs8.a r8 = this.f;
        String r11 = r7.a;
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        com.larus.bmhome.taskskill.view.b r1 = d.a(new bs8.h(r11, r8), r28, new e());
        FLogger r12 = FLogger.a;
        r12.i("PcConnectionStatusManager", "[updateConnectionStatus] resolved status=" + r1);
        com.larus.bmhome.taskskill.view.b.d r15 = com.larus.bmhome.taskskill.view.b.d.a;
        if (Intrinsics.areEqual(r1, r15) == false) goto L34;
        this.b.e("PcConnectionStatusManager.doWhenDeviceNotFound");
        this.h.postValue(r15);
        return;
    L34:
        com.larus.bmhome.taskskill.view.b.e r16 = com.larus.bmhome.taskskill.view.b.e.a;
        if (Intrinsics.areEqual(r1, r16) == false) goto L37;
        this.b.e("PcConnectionStatusManager.doWhenDeviceOffline");
        this.h.postValue(r16);
        return;
    L37:
        com.larus.bmhome.taskskill.view.b.c r17 = com.larus.bmhome.taskskill.view.b.c.a;
        if (Intrinsics.areEqual(r1, r17) == false) goto L40;
        this.b.e("PcConnectionStatusManager.doWhenNeedUpgrade");
        this.h.postValue(r17);
        return;
    L40:
        com.larus.bmhome.taskskill.view.b.a r18 = com.larus.bmhome.taskskill.view.b.a.a;
        if (Intrinsics.areEqual(r1, r18) == false) goto L43;
        this.b.d();
        this.h.postValue(r18);
        return;
    L43:
        com.larus.bmhome.taskskill.view.b.g r19 = com.larus.bmhome.taskskill.view.b.g.a;
        if (Intrinsics.areEqual(r1, r19) == false) goto L60;
        this.b.e("PcConnectionStatusManager.doWhenDeviceNotControl");
        this.h.postValue(r19);
        String r20 = l2.d(this.f, null);
        GetAllDevicesRepo r21 = GetAllDevicesRepo.a;
        Integer r22 = GetAllDevicesRepo.c(r20);
        if (r22 == null) goto L48;
        r14 = r22.intValue();
    L48:
        StringBuilder r23 = new StringBuilder("[sendPermissionControlCommand] start, localPcDeviceId=");
        r23.append(r20);
        r23.append(", deviceName=");
        bs8.a r24 = this.f;
        if (r24 == null) goto L51;
        r10 = r24.a;
    L51:
        r23.append(r10);
        r12.i("PcConnectionStatusManager", r23.toString());
        NativeCmdServiceImpl r25 = com.larus.im.d.b();
        if (r20 != null) goto L54;
        String r26 = "";
    L55:
        DispatchCommand r110 = DispatchCommand.DEVICE_ENABLE_CONTROL_REQUEST;
        String r111 = UUID.randomUUID().toString();
        if (r20 != null) goto L58;
        String r27 = "";
    L59:
        r25.sendDispatchCommand(new OmniDispatchCommandRequest(r26, r14, new DispatchCommandPayload(r110, r111, null, null, r27, null, 0, null, null, 492, null)), new o());
        return;
    L58:
        r27 = r20;
        goto L59
    L54:
        r26 = r20;
        goto L55
    L60:
        com.larus.bmhome.taskskill.view.b.f r30 = com.larus.bmhome.taskskill.view.b.f.a;
        if (Intrinsics.areEqual(r1, r30) == false) goto L63;
        this.b.e("PcConnectionStatusManager.doWhenDeviceNotAuthorized");
        this.h.postValue(r30);
        return;
    L63:
        com.larus.bmhome.taskskill.view.b.C0038b r31 = com.larus.bmhome.taskskill.view.b.C0038b.a;
        if (Intrinsics.areEqual(r1, r31) == false) goto L66;
        this.h.postValue(r31);
        return;
    L66:
        if (r1 != null) goto L69;
        return;
    L69:
        throw new NoWhenBranchMatchedException();
    L19:
        if (StringsKt.isBlank(r5) == true) goto L22;
        r6 = false;
    L70:
        LayoutPcConnectionStatusBinding r32 = this.e;
        if (r32 == null) goto L81;
        PcConnectionStatusView r33 = r32.a;
        if (r33 == null) goto L81;
        com.larus.bmhome.taskskill.view.b.a r34 = com.larus.bmhome.taskskill.view.b.a.a;
        bs8.a r35 = this.f;
        if (r35 == null) goto L77;
        r10 = r35.a;
    L77:
        if (r10 == null) goto L80;
        r9 = r10;
    L80:
        r33.D(d.b(r34, r9));
    L81:
        this.b.g();
    }

    public final void a(String r7, String r8, boolean r9) {
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        if (StringsKt.isBlank(r7) == true) goto L12;
        if (r9 == false) goto L8;
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new PcConnectionStatusManager$authorizeDevice$1(r7, r8, this, null), 3, null);
        return;
    L8:
        if (StringsKt.isBlank(r8) == false) goto L10;
    L12:
        FLogger.a.w("PcConnectionStatusManager", "[authorizeDevice] invalid params, targetDeviceId=" + r7 + ", ticketBlank=" + StringsKt.isBlank(r8));
    }
}
