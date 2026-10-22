package com.bytedance.ai.applet.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import f2.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1", f = "AppletAuthorizeHelper.kt", i = {1, 2}, l = {201, 204, 259}, m = "invokeSuspend", n = {"userAction", "isSystemAlreadyGranted"}, s = {"L$0", "I$0"})
public final class AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ AppletAuthTaskMonitor.Session $authTaskSession;
    final /* synthetic */ boolean $isAppletAlreadyGranted;
    final /* synthetic */ String $resultDetail;
    final /* synthetic */ String $scopeName;
    final /* synthetic */ ScopePermissionInfo $scopePermissionInfo;
    final /* synthetic */ boolean $skipDialogIfDenied;
    final /* synthetic */ AppletPermissionDetail $targetAppletDetail;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GrantingAction.values().length];
            r0[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1(boolean r1, String r10, boolean r11, AppletAuthorizeHelper r12, ScopePermissionInfo r13, AppletAuthTaskMonitor.Session r14, String r15, AppletPermissionDetail r16, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1> r17) {
        this.$isAppletAlreadyGranted = r1;
        this.$scopeName = r10;
        this.$skipDialogIfDenied = r11;
        this.this$0 = r12;
        this.$scopePermissionInfo = r13;
        this.$authTaskSession = r14;
        this.$resultDetail = r15;
        this.$targetAppletDetail = r16;
        super(2, r17);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1(this.$isAppletAlreadyGranted, this.$scopeName, this.$skipDialogIfDenied, this.this$0, this.$scopePermissionInfo, this.$authTaskSession, this.$resultDetail, this.$targetAppletDetail, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        String r11 = "already_granted";
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 3) goto L9;
        int r12 = this.I$0;
        ResultKt.throwOnFailure(r29);
        Object r13 = r29;
        r11 = "already_granted";
    L100:
        if (((Boolean) r13).booleanValue() == true) goto L107;
        Pair[] r14 = new Pair[2];
        if (this.$isAppletAlreadyGranted == false) goto L104;
        String r15 = r11;
    L105:
        r14[0] = TuplesKt.to("applet_auth_status", r15);
        r14[1] = TuplesKt.to("system_auth_status", "denied");
        throw new AppletAuthorizeHelper.AuthorizeException("system_permission_denied", MapsKt.mapOf(r14));
    L104:
        r15 = "approved";
        goto L105
    L107:
        int r16 = r12;
    L109:
        if (r16 == 0) goto L111;
        boolean r17 = true;
    L113:
        return Boxing.boxBoolean(r17);
    L111:
        r17 = false;
        goto L113
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        GrantingAction r18 = (GrantingAction) this.L$0;
        ResultKt.throwOnFailure(r29);
        Object r19 = r29;
        r11 = "already_granted";
    L38:
        if (((Boolean) r19).booleanValue() == false) goto L40;
    L42:
        int r20 = a.a[r18.ordinal()];
        if (r20 == 1) goto L55;
        if (r20 == 2) goto L53;
        if (r20 == 3) goto L51;
        throw new NoWhenBranchMatchedException();
    L51:
        throw new AppletAuthorizeHelper.AuthorizeException("applet_permission_cancelled", MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_auth_status", "cancelled"), TuplesKt.to("system_auth_status", "not_reached")}));
    L53:
        throw new AppletAuthorizeHelper.AuthorizeException("applet_permission_denied", MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_auth_status", "denied"), TuplesKt.to("system_auth_status", "not_reached")}));
    L55:
        if (this.this$0.b != CastIntegerProtector.parseInt("2")) goto L58;
        com.bytedance.ai.utils.g.a.i("AppletAuthorizeHelper", "Authorization flow completed for native app: applet: " + this.this$0.a + ", " + this.$scopeName);
        return Boxing.boxBoolean(true);
    L58:
        int r21 = h.a;
        String r22 = h.b(this.$scopeName);
        if (r22 != null) goto L61;
    L64:
        boolean r23 = true;
    L65:
        if (r23 == false) goto L67;
        AppletAuthorizeHelper r24 = this.this$0;
        String r25 = this.$scopeName;
        r24.getClass();
        throw new AppletAuthorizeHelper.AuthorizeException("invalid_scope:" + r25, null, 2, null);
    L67:
        if (this.$skipDialogIfDenied == false) goto L88;
        this.this$0.getClass();
        Activity r26 = k.b();
        if (r26 != null) goto L72;
    L79:
        boolean r27 = false;
    L81:
        if (r27 == false) goto L88;
        com.bytedance.ai.utils.g.a.e("AppletAuthorizeHelper", "System permission permanently denied: " + r22);
        Pair[] r28 = new Pair[2];
        if (this.$isAppletAlreadyGranted == false) goto L85;
        String r30 = r11;
    L86:
        r28[0] = TuplesKt.to("applet_auth_status", r30);
        r28[1] = TuplesKt.to("system_auth_status", "denied");
        throw new AppletAuthorizeHelper.AuthorizeException("system_permission_denied", MapsKt.mapOf(r28));
    L85:
        r30 = "approved";
        goto L86
    L72:
        if (ContextCompat.checkSelfPermission(r26, r22) != 0) goto L74;
        boolean r31 = true;
    L75:
        if (r31 == true) goto L79;
        if (((Keva) AppletAuthorizeHelper.d.getValue()).getBoolean("requested_" + r22, false) == false) goto L79;
        r27 = !ActivityCompat.shouldShowRequestPermissionRationale(r26, r22);
        goto L81
    L74:
        r31 = false;
    L88:
        Activity r32 = k.b();
        if (r32 != null) goto L91;
    L93:
        r16 = 0;
    L94:
        if (r16 != 0) goto L109;
        AppletAuthTaskMonitor.Session r33 = this.$authTaskSession;
        AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1 r34 = new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1(this.this$0, r22, null);
        this.L$0 = null;
        this.I$0 = r16;
        this.label = 3;
        r13 = r33.g(r34, this);
        if (r13 != r1) goto L98;
        return r1;
    L98:
        r12 = r16;
        goto L100
    L91:
        if (ContextCompat.checkSelfPermission(r32, r22) != 0) goto L93;
        r16 = 1;
        goto L94
    L61:
        if (r22.length() == 0) goto L64;
        r23 = false;
        goto L65
    L40:
        if (r18 != GrantingAction.AGREED) goto L42;
        this.$authTaskSession.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, this.$resultDetail, "permission_post", AppletAuthTaskMonitor.ErrorCode.API_FAILED, "post user permission action failed", "granted", null, "refused", 160));
        goto L42
    L11:
        ResultKt.throwOnFailure(r29);
        Object r35 = r29;
        Continuation r36 = null;
    L34:
        r18 = (GrantingAction) r35;
        AppletAuthTaskMonitor.Session r37 = this.$authTaskSession;
        AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1 r38 = new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1(this.this$0, this.$scopeName, r18, r36);
        this.L$0 = r18;
        this.label = 2;
        r19 = r37.f(r38, this);
        if (r19 != r1) goto L38;
        return r1;
    L12:
        ResultKt.throwOnFailure(r29);
        if (this.$isAppletAlreadyGranted == false) goto L16;
        com.bytedance.ai.utils.g.a.i("AppletAuthorizeHelper", "Scope '" + this.$scopeName + "' granted, request system permission.");
        r11 = "already_granted";
        goto L55
    L16:
        if (this.$skipDialogIfDenied == false) goto L31;
        AppletAuthorizeHelper r39 = this.this$0;
        ScopePermissionInfo r40 = this.$scopePermissionInfo;
        Lazy<Keva> r110 = AppletAuthorizeHelper.d;
        r39.getClass();
        if (r40 == null) goto L26;
        Integer r41 = r40.getGrantStatus();
        if (r41 == null) goto L26;
        int r42 = r41.intValue();
        if (r42 != GrantStatus.DENIED.getValue()) goto L24;
    L25:
        boolean r43 = true;
    L27:
        if (r43 == false) goto L31;
        com.bytedance.ai.utils.g.a.e("AppletAuthorizeHelper", "Scope '" + this.$scopeName + "' denied/revoked, skip dialog.");
        throw new AppletAuthorizeHelper.AuthorizeException("applet_permission_denied", MapsKt.mapOf(new Pair[]{TuplesKt.to("applet_auth_status", "denied"), TuplesKt.to("system_auth_status", "not_reached")}));
    L24:
        if (r42 == GrantStatus.REVOKED.getValue()) goto L25;
    L26:
        r43 = false;
    L31:
        com.bytedance.ai.utils.g.a.d("AppletAuthorizeHelper", "Scope '" + this.$scopeName + "' not granted, showing dialog.");
        AppletAuthTaskMonitor.Session r44 = this.$authTaskSession;
        r36 = null;
        AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1 r45 = new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$userAction$1(this.this$0, this.$scopeName, this.$targetAppletDetail, null);
        this.label = 1;
        r35 = r44.g(r45, this);
        if (r35 != r1) goto L34;
        return r1;
    }
}
