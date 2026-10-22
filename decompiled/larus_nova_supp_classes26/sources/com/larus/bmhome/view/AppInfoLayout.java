package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusLayoutAppInfoBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.o0;
import com.obric.assistant.common.spi.IObricEnvService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001d\u001a\u00020\u001bJ\f\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0002J\f\u0010!\u001a\u00060\u001fj\u0002` H\u0002J\u0006\u0010\"\u001a\u00020\u000fR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/AppInfoLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutAppInfoBinding;", "tvVersionInfoText", "", "tvDeviceIdText", "tvUserIdText", "tvGitBranchText", "tvGitCommitIdText", "tvJobIdText", "tvMrIdText", "tvChannelText", "tvPreInstallChannel", "tvVersionCodeText", "tvUpdateVersionCodeText", "initVersionText", "", "showBasicInfo", "showMoreInfo", "getBasicInfoTextBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getMoreInfoTextBuilder", "getMessage", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppInfoLayout extends LinearLayout {
    public LarusLayoutAppInfoBinding a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    private final StringBuilder getBasicInfoTextBuilder() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvVersionInfoText");
        r1 = null;
    L5:
        r0.append(r1);
        if (AppHost.a.isTestChannel() == false) goto L8;
        r0.append("\n");
        r0.append(this.e);
    L8:
        return r0;
    }

    private final StringBuilder getMoreInfoTextBuilder() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.b;
        String r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvVersionInfoText");
        r1 = null;
    L5:
        r0.append(r1);
        r0.append("\n");
        r0.append(this.j);
        r0.append("\n");
        r0.append(this.k);
        r0.append("\n");
        String r3 = this.c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tvDeviceIdText");
        r3 = null;
    L8:
        r0.append(r3);
        r0.append("\n");
        String r4 = this.d;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvUserIdText");
        r4 = null;
    L11:
        r0.append(r4);
        r0.append("\n");
        r0.append(this.h);
        if (o0.d(this.i) == false) goto L14;
        r0.append("\n");
        r0.append(this.i);
    L14:
        AppHost.Companion r5 = AppHost.a;
        boolean r6 = false;
        if (r5.isTestChannel() == false) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L28;
        com.larus.platform.service.z2 r8 = com.larus.platform.service.z2.a;
        if (r8.B().length() <= 0) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L28;
        r0.append("\n");
        r0.append("AudioSdk: ".concat(r8.B()));
        goto L28
    L25:
        r9 = false;
    L28:
        if (r7 == false) goto L35;
        com.larus.platform.service.z2 r10 = com.larus.platform.service.z2.a;
        if (r10.Q1().length() <= 0) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == false) goto L35;
        r0.append("\n");
        r0.append("DoraSdk: ".concat(r10.Q1()));
        goto L35
    L32:
        r11 = false;
    L35:
        if (r7 == false) goto L42;
        com.larus.platform.service.z2 r12 = com.larus.platform.service.z2.a;
        if (r12.r2().length() <= 0) goto L39;
        boolean r13 = true;
    L40:
        if (r13 == false) goto L42;
        r0.append("\n");
        r0.append("OfficeSdk: ".concat(r12.r2()));
        goto L42
    L39:
        r13 = false;
    L42:
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L47;
        com.larus.home.impl.sdk.s r15 = r14.s0();
        if (r15 == null) goto L47;
        String r16 = r15.t();
    L48:
        if (r7 == true) goto L50;
    L52:
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L57;
        com.larus.home.impl.sdk.s r18 = r17.s0();
        if (r18 == null) goto L57;
        String r19 = r18.W();
    L58:
        if (r7 == true) goto L60;
    L62:
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r20 == null) goto L67;
        com.larus.home.impl.sdk.s r21 = r20.s0();
        if (r21 == null) goto L67;
        r2 = r21.Q();
    L67:
        if (r7 == false) goto L72;
        if (o0.d(r2) == false) goto L72;
        r0.append("\n");
        r0.append("imageProcessor：" + r2);
    L72:
        if (this.f.length() <= 0) goto L74;
        boolean r22 = true;
    L75:
        if (r22 == false) goto L77;
        r0.append("\n");
        r0.append(this.f);
    L77:
        if (r7 == false) goto L85;
        if (this.g.length() <= 0) goto L81;
        boolean r23 = true;
    L82:
        if (r23 == false) goto L85;
        r0.append("\n");
        r0.append(this.g);
        goto L85
    L81:
        r23 = false;
    L85:
        if (r5.isTestChannel() == true) goto L93;
        IObricEnvService r24 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r24 != null) goto L89;
    L91:
        boolean r25 = false;
    L92:
        if (r25 == true) goto L93;
    L98:
        IObricEnvService r26 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r26 == null) goto L101;
        r26.c(r0);
    L101:
        return r0;
    L89:
        if (r24.d() != true) goto L91;
        r25 = true;
    L93:
        com.larus.platform.service.z2 r27 = com.larus.platform.service.z2.a;
        if (r27.z0().length() <= 0) goto L96;
        r6 = true;
    L96:
        if (r6 == false) goto L98;
        r0.append("\n");
        r0.append("Build Date：".concat(r27.z0()));
        goto L98
    L74:
        r22 = false;
        goto L75
    L60:
        if (o0.d(r19) == false) goto L62;
        r0.append("\n");
        r0.append("videoProcessor：" + r19);
    L57:
        r19 = null;
        goto L58
    L50:
        if (o0.d(r16) == false) goto L52;
        r0.append("\n");
        r0.append("Earbuds RTOS：" + r16);
    L47:
        r16 = null;
        goto L48
    L17:
        if (Intrinsics.areEqual(r5.getBuildChannel(), "auto_test") == true) goto L20;
        r7 = false;
        goto L21
    }

    public final void a() {
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        if (r0.U1() == false) goto L5;
        String r1 = "Version: " + AppHost.a.getVersionName() + "-In-house";
    L6:
        this.b = r1;
        StringBuilder r2 = new StringBuilder("VersionCode: ");
        AppHost.Companion r3 = AppHost.a;
        r2.append(r3.getVersionCode());
        this.j = r2.toString();
        this.k = "UpdateVersionCode: " + r3.getUpdateVersionCode();
        this.h = "Channel: " + r3.getBuildChannel();
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        Integer r5 = null;
        if (r4 == null) goto L9;
        r4.T();
        String r6 = com.larus.home.impl.sdk.h2.a.c();
    L11:
        if (o0.d(r6) == false) goto L13;
        this.i = "Preinstall Channel: " + r6;
    L13:
        this.c = "DeviceId: " + r0.getDeviceId();
        StringBuilder r7 = new StringBuilder("Uid: ");
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L16;
        r8.getAccountService();
        String r9 = com.larus.home.impl.sdk.d.a.getUserId();
    L17:
        r7.append(r9);
        this.d = r7.toString();
        boolean r10 = false;
        if (r0.X1().length() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L24;
        this.e = "Branch: ".concat(r0.X1());
    L24:
        if (r0.t1().length() <= 0) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L29;
        this.f = "CommitId: ".concat(r0.t1());
    L29:
        Integer r13 = Integer.valueOf(r0.p0());
        if (r13.intValue() <= 0) goto L32;
        boolean r14 = true;
    L33:
        if (r14 == false) goto L35;
        r5 = r13;
    L35:
        if (r5 == null) goto L38;
        this.g = "JobId：" + r5.intValue();
    L38:
        if (r0.O3().length() <= 0) goto L40;
        r10 = true;
    L40:
        if (r10 == false) goto L43;
        r0.O3();
        return;
    L43:
        return;
    L32:
        r14 = false;
        goto L33
    L26:
        r12 = false;
        goto L27
    L20:
        r11 = false;
        goto L21
    L16:
        r9 = null;
        goto L17
    L9:
        r6 = null;
        goto L11
    L5:
        r1 = "Version: " + AppHost.a.getVersionName();
        goto L6
    }

    public final void c() {
        LarusLayoutAppInfoBinding r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.b.setText(getMoreInfoTextBuilder().toString());
    }

    public final String getMessage() {
        LarusLayoutAppInfoBinding r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        return r0.b.getText().toString();
    }

    public AppInfoLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        a();
        b(r2);
    }

    public final void b(Context r3) {
        LayoutInflater.from(r3).inflate(2131562739, this);
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131390779);
        if (r0 == null) goto L10;
        this.a = new LarusLayoutAppInfoBinding(this, r0);
        setOrientation(1);
        LarusLayoutAppInfoBinding r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L7:
        r4.b.setText(getBasicInfoTextBuilder().toString());
        return;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(2131390779)));
    }

    public AppInfoLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        a();
        b(r2);
    }

    public AppInfoLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        a();
        b(r2);
    }
}
