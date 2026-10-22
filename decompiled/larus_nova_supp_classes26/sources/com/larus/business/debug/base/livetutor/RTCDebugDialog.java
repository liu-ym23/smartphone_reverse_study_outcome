package com.larus.business.debug.base.livetutor;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.business.debug.api.RTCDebugInfo;
import com.larus.business.debug.base.databinding.LarusDebugTutorDialogLayoutBinding;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001f\u001a\u00020\u001dJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/larus/business/debug/base/livetutor/RTCDebugDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "rtcInfo", "Lcom/larus/business/debug/api/RTCDebugInfo;", "bizContent", "", "(Lcom/larus/business/debug/api/RTCDebugInfo;Ljava/lang/String;)V", "viewModel", "Lcom/larus/business/debug/base/livetutor/RTCDebugViewModel;", "getViewModel", "()Lcom/larus/business/debug/base/livetutor/RTCDebugViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/business/debug/base/databinding/LarusDebugTutorDialogLayoutBinding;", "getBinding", "()Lcom/larus/business/debug/base/databinding/LarusDebugTutorDialogLayoutBinding;", "binding$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "handleCopy", "content", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCDebugDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public final RTCDebugInfo d;
    public final String e;
    public final Lazy f;
    public final Lazy g;

    public RTCDebugDialog() {
        this(null, null);
    }

    public final LarusDebugTutorDialogLayoutBinding T90() {
        return (LarusDebugTutorDialogLayoutBinding) this.g.getValue();
    }

    public final void U90(String r9) {
        Object r0 = AppHost.a.getApplication().getSystemService("clipboard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r1 = (ClipboardManager) r0;
        ClipData r10 = ClipData.newPlainText("simple text", r9);
        Intrinsics.checkNotNullParameter(r10, "clip");
        FLogger.a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        S90(r1, r10);     // Catch: Exception -> L5
    L7:
        s.j(s.a, getContext(), "已复制", null, false, 28);
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        goto L7
    }

    public RTCDebugDialog(RTCDebugInfo r2, String r3) {
        this.f = LazyKt.lazy(new f(this));
        this.g = LazyKt.lazy(new g(this));
        this.d = r2;
        this.e = r3;
    }

    public static void S90(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        Dialog r7 = getDialog();
        boolean r8 = false;
        if (r7 == null) goto L7;
        Window r9 = r7.getWindow();
        if (r9 == null) goto L7;
        r9.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r10 = getDialog();
        if (r10 == null) goto L12;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L12;
        r11.setLayout(-1, -1);
    L12:
        T90().j.setOnClickListener(new a(this));
        StringBuilder r12 = new StringBuilder("rtcAppId: ");
        RTCDebugInfo r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L15;
        String r2 = r0.getRtcAppId();
    L16:
        r12.append(r2);
        r12.append("\nroomId: ");
        RTCDebugInfo r3 = this.d;
        if (r3 == null) goto L19;
        String r4 = r3.getRoomID();
    L20:
        r12.append(r4);
        r12.append("\ntutorId: ");
        RTCDebugInfo r13 = this.d;
        if (r13 == null) goto L23;
        Long r14 = r13.getTutorId();
    L24:
        r12.append(r14);
        r12.append("\ncallId: ");
        RTCDebugInfo r15 = this.d;
        if (r15 == null) goto L27;
        Long r16 = Long.valueOf(r15.getRtcCallId());
    L28:
        r12.append(r16);
        r12.append("\nbotId: ");
        RTCDebugInfo r17 = this.d;
        if (r17 == null) goto L31;
        String r18 = r17.getBotID();
    L32:
        r12.append(r18);
        r12.append("\nuid: ");
        r12.append(AccountService.a.getUserId());
        r12.append("\ndid: ");
        r12.append(IApplog.a.getDeviceId());
        r12.append("\nsdkVersion: ");
        RTCDebugInfo r19 = this.d;
        if (r19 == null) goto L35;
        String r20 = r19.getSdkVersion();
    L36:
        r12.append(r20);
        r12.append("\n---------------------------------------\n");
        r12.append(this.e);
        final String r21 = r12.toString();
        T90().b.setText(r21);
        T90().c.setOnClickListener(new b(this, r21));
        Context r22 = getContext();
        if (r22 == null) goto L39;
        File r23 = r22.getFilesDir();
    L40:
        StringBuilder r24 = new StringBuilder("rtc_test_");
        RTCDebugInfo r25 = this.d;
        if (r25 == null) goto L43;
        r1 = r25.getBotID();
    L43:
        r24.append(r1);
        PolarisFileWrapper r26 = new PolarisFileWrapper(r23, r24.toString());
        if (r26.exists() == true) goto L46;
    L58:
        T90().i.setText("无录音文件");
        e1.o(T90().e);
    L59:
        TextView r27 = T90().f;
        T90().d.setOnClickListener(new d(this));
        r27.setText("");
        T90().g.setOnClickListener(new e(this));
        return;
    L46:
        if (r26.isDirectory() == false) goto L58;
        File[] r28 = r26.listFiles();
        if (r28 != null) goto L50;
    L56:
        if (r8 == false) goto L58;
        T90().i.setText("录音文件已存在");
        e1.x(T90().e);
        T90().e.setOnClickListener(new c(this));
        goto L59
    L50:
        if (r28.length != 0) goto L52;
        boolean r29 = true;
    L54:
        if ((!r29) != true) goto L56;
        r8 = true;
        goto L56
    L52:
        r29 = false;
        goto L54
    L39:
        r23 = null;
        goto L40
    L35:
        r20 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r16 = null;
        goto L28
    L23:
        r14 = null;
        goto L24
    L19:
        r4 = null;
        goto L20
    L15:
        r2 = null;
        goto L16
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return T90().a;
    }
}
