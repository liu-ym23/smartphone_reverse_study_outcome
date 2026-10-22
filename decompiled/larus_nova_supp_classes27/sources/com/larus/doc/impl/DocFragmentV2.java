package com.larus.doc.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.util.DocUtils;
import com.larus.doc.impl.view.InterceptTouchFrameLayout;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.view.DocLoadAndErrorLayout;
import com.larus.office.base.view.TextLoadingView;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J0\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\b\u00105\u001a\u000200H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\b\u0010<\u001a\u00020!H\u0016J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020!H\u0016J\b\u0010?\u001a\u00020!H\u0016J\b\u0010@\u001a\u00020!H\u0016J\f\u0010A\u001a\u00020\u000f*\u00020\u0017H\u0002J\f\u0010B\u001a\u00020\u000f*\u00020\u0017H\u0002J\b\u0010C\u001a\u00020\u000fH\u0002J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010G\u001a\u00020\u000f2\b\u0010H\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010I\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\u0016\u0010L\u001a\u00020\u000f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0NH\u0016J\b\u0010O\u001a\u00020PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006S"}, d2 = {"Lcom/larus/doc/impl/DocFragmentV2;", "Lcom/larus/doc/impl/DocFragment;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "initialDocId", "", "getInitialDocId", "()Ljava/lang/String;", "initialDocId$delegate", "Lkotlin/Lazy;", "getPermissionAbility", "setupServices", "", "attachComponentBeforeCreateDocx", "initPermissionAbility", "initFragment", "it", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "generateDocLogicKeyForFindService", "createOfficeFragment", "Landroidx/fragment/app/Fragment;", "context", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyChatInputVisibilityChanged", "visible", "", "onFloatChatFragmentCreated", "updateArtifactInfo", "artifactMetaId", "artifactVersionId", "conversationId", "bindedMessageId", "buildEnterPageExtraParams", "Lorg/json/JSONObject;", "updateDocOpBarVisibility", "tryShow", "needAdjustPanelHeight", "notifyEditPanelHeightChanged", "updateDocBrief", "getChatPanelHeight", "", "getChatInputFragmentHeight", "onBackPressed", "foldStatusChanged", "setupChatAndOpBarContainer", "getChatContainerId", "getTitleView", "Landroid/view/ViewGroup;", "onDestroy", "canManage", "canCopy", "canShare", "canRead", "canDelete", "canEdit", "reviewSuccess", "isOwner", "gray", "available", "adaptViewByPermission", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", "fragment", "getToken", "getNoPermissionContainerId", "getOfficeContainerId", "runWhenAdded", "action", "Lkotlin/Function0;", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFragmentV2 extends DocFragment implements com.larus.office.base.component.permission.c {
    public static final /* synthetic */ int O2 = 0;
    public com.larus.office.base.component.permission.a M2;
    public final Lazy N2;

    public static final class a {
    }

    static {
    }

    public final int C3() {
        return 2131369315;
    }

    public final int J7() {
        return 2131369341;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final int Z90() {
        return 2131369293;
    }

    public final void Ca0() {
        k1a.b.a(this, new j1(this));
        com.larus.office.base.component.permission.a r0 = s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
        this.M2 = r0;
        if (r0 == null) goto L5;
        r0.mW(this);
    L5:
        com.larus.office.base.component.permission.a r1 = this.M2;
        if (r1 == null) goto L9;
        r1.R20(new r1(this));
    L9:
        if (this.X != null) goto L31;
        s1a.a.g(this).c(this.Y, com.larus.doc.impl.offline.d.class);
        k1a.b.a(this, new g(this));
        this.X = s1a.a.g(this).getAbility(com.larus.doc.impl.offline.c.class);
        if (z2.a.getDocFusionConfig().a == false) goto L14;
        int r6 = 10;
    L15:
        Bundle r2 = getArguments();
        boolean r3 = false;
        if (r2 == null) goto L18;
        r3 = r2.getBoolean("key_is_in_main_conversation", false);
    L18:
        if (r3 == false) goto L20;
        int r7 = 2;
    L21:
        com.larus.doc.impl.offline.c r4 = this.X;
        if (r4 == null) goto L30;
        String r5 = this.H;
        String r8 = this.f;
        String r9 = this.P;
        Bundle r10 = getArguments();
        Long r11 = null;
        if (r10 == null) goto L28;
        String r12 = r10.getString("key_message_id", null);
        if (r12 == null) goto L28;
        r11 = StringsKt.toLongOrNull(r12);
    L28:
        r4.QN(new com.larus.doc.impl.offline.f(r5, r8, r9, r11, r6, r7, this.k));
        return;
    L30:
        return;
    L20:
        r7 = 1;
        goto L21
    L14:
        r6 = 3;
        goto L15
    }

    public final JSONObject Da0() {
        JSONObject r0 = new JSONObject();
        com.larus.office.base.component.permission.a r1 = Ea0();
        String r3 = null;
        if (r1 == null) goto L18;
        DocPermissionFullData r2 = r1.C4();
        if (r2 == null) goto L18;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (fo9.e.f(r2) == true) goto L10;
        String r4 = "review_rejected";
    L19:
        JSONObject r5 = r0.put("doc_status", r4);
        com.larus.office.base.component.permission.a r6 = Ea0();
        if (r6 == null) goto L27;
        DocPermissionFullData r7 = r6.C4();
        if (r7 == null) goto L27;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (fo9.e.e(r7) == false) goto L26;
        String r8 = "self_created";
    L28:
        JSONObject r9 = r5.put("ai_doc_owner_type", r8);
        Bundle r10 = getArguments();
        if (r10 == null) goto L31;
        String r11 = r10.getString("feishu_record_id", null);
    L32:
        JSONObject r12 = r9.put("feishu_record_id", r11);
        Bundle r13 = getArguments();
        if (r13 == null) goto L35;
        String r14 = r13.getString("feishu_record_generated_type", null);
    L36:
        JSONObject r15 = r12.put("feishu_record_generated_type", r14);
        Bundle r16 = getArguments();
        if (r16 == null) goto L39;
        String r17 = r16.getString("record_scene", null);
    L40:
        JSONObject r18 = r15.put("record_scene", r17);
        Bundle r20 = getArguments();
        if (r20 == null) goto L43;
        String r21 = r20.getString("is_general_agent", null);
    L45:
        if (r21 != null) goto L47;
    L50:
        boolean r22 = true;
    L52:
        if ((true ^ r22) == true) goto L55;
        r21 = null;
    L55:
        if (r21 != null) goto L57;
        r21 = "0";
    L57:
        JSONObject r23 = r18.put("is_general_agent", r21);
        Bundle r24 = getArguments();
        if (r24 == null) goto L60;
        r3 = r24.getString("chat_id", null);
    L60:
        if (r3 != null) goto L63;
        r3 = "";
    L63:
        return r23.put("chat_id", r3);
    L47:
        if (r21.length() == 0) goto L50;
        r22 = false;
        goto L52
    L43:
        r21 = null;
        goto L45
    L39:
        r17 = null;
        goto L40
    L35:
        r14 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L26:
        r8 = "other_created";
    L27:
        r8 = null;
        goto L28
    L10:
        if (fo9.e.c(r2) == true) goto L12;
    L17:
        r4 = "lack_permission";
        goto L19
    L12:
        if (fo9.e.a(r2) == false) goto L17;
        if (fo9.e.b(r2) == false) goto L17;
        r4 = "normal";
    L18:
        r4 = null;
        goto L19
    }

    public final com.larus.office.base.component.permission.a Ea0() {
        com.larus.office.base.component.permission.a r0 = this.M2;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final String Y90() {
        String r1 = "fake_offline_doc_id";
        if (Intrinsics.areEqual((String) this.N2.getValue(), "fake_offline_doc_id") == true) goto L6;
        r1 = this.f;
    L6:
        DocUtils r0 = DocUtils.a;
        long r2 = this.g2;
        r0.getClass();
        return r1 + '_' + r2;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final int aa0() {
        ViewGroup r0 = this.t;
        int r1 = 0;
        if (r0 == null) goto L7;
        View r2 = r0.findViewById(2131364480);
        if (r2 == null) goto L7;
        int r3 = r2.getBottom();
    L11:
        View r4 = this.q;
        boolean r5 = true;
        if (r4 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L23;
        View r7 = this.q;
        if (r7 == null) goto L21;
        int r8 = r7.getHeight();
    L22:
        r3 = r3 + r8;
        goto L23
    L21:
        r8 = 0;
    L23:
        TextLoadingView r9 = this.u;
        if (r9 != null) goto L26;
    L28:
        r5 = false;
    L29:
        if (r5 == false) goto L35;
        TextLoadingView r10 = this.u;
        if (r10 == null) goto L34;
        r1 = r10.getHeight();
    L34:
        return r3 + r1;
    L35:
        return r3;
    L26:
        if (r9.getVisibility() != 0) goto L28;
    L14:
        if (r4.getVisibility() != 0) goto L16;
        r6 = true;
    L7:
        ViewGroup r11 = this.t;
        if (r11 == null) goto L10;
        r3 = r11.getHeight();
        goto L11
    L10:
        r3 = 0;
        goto L11
    }

    @Override // com.larus.doc.impl.DocFragment
    public final ViewGroup fa0() {
        LarusLayoutDocDetailFragmentBinding r0 = this.g;
        if (r0 == null) goto L5;
        ConstraintLayout r1 = r0.h;
    L6:
        if (r1 == null) goto L8;
        ViewParent r2 = r1.getParent();
    L9:
        if (r2 == null) goto L16;
        ViewParent r3 = r1.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
    L14:
        if (r4 == null) goto L16;
        r4.removeView(r1);
        goto L16
    L13:
        r4 = null;
    L16:
        LarusLayoutDocDetailFragmentBinding r5 = this.g;
        if (r5 == null) goto L32;
        DocLoadAndErrorLayout r6 = r5.d;
        if (r6 == null) goto L32;
        if (r5 == null) goto L23;
        if (r6 == null) goto L23;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L25:
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
    L28:
        if (r8 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = i5.k0();
    L31:
        r6.setLayoutParams(r8);
        goto L32
    L30:
        r8 = null;
        goto L31
    L27:
        r8 = null;
    L23:
        r7 = null;
    L32:
        LarusLayoutDocDetailFragmentBinding r9 = this.g;
        if (r9 != null) goto L35;
        return null;
    L35:
        return r9.h;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void la0() {
        FLogger.a.i("[doc_input_focus]", "notifyEditPanelHeightChanged called");
        Lazy r0 = com.larus.office.base.service.m.a;
        ym9.c r1 = com.larus.office.base.service.m.a(Y90());
        if (r1 == null) goto L6;
        r1.onEditPanelHeightChanged(36);
        return;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ma0() {
        if (this.p1 == false) goto L5;
    L24:
        SoftReference r0 = com.larus.utils.y.a;
        Runnable r1 = new l1(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        com.larus.utils.y.d(r1, 500);
        return;
    L5:
        if (this.k1 <= 0) goto L24;
        long r2 = System.currentTimeMillis() - this.k1;
        if (r2 >= 0) goto L10;
        FLogger.a.i("DocFragment", "[reportDocFloatChatCreatedDurationIfNeeded] invalid duration=" + r2);
        goto L24
    L10:
        FLogger.a.i("DocFragment", "[reportDocFloatChatCreatedDurationIfNeeded] duration=" + r2);
        boolean r3 = true;
        this.p1 = true;
        com.larus.doc.impl.offline.c r4 = this.X;
        if (r4 != null) goto L13;
    L15:
        r3 = false;
    L16:
        Boolean r5 = Boolean.valueOf(r3);
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        r6.put("duration", r2);     // Catch: JSONException -> L21
        if (r5 == null) goto L23;
        r6.put("isOfflineDocCreated", r5.booleanValue());     // Catch: JSONException -> L21
    L23:
        TrackParams r7 = new TrackParams().merge(r6);
        by7.a r8 = new by7.a("doc_float_chat_created_duration");
        r8.a.merge(r7);
        r8.b();
    L21:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocFloatChatCreatedDuration: " + e.getLocalizedMessage());
        goto L23
    L13:
        if (r4.BK() != true) goto L15;
        goto L15
    }

    public final void onBackPressed() {
        Fragment r0 = this.h;
        boolean r1 = true;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L28;
        Fragment r4 = this.h;
        if (r4 == null) goto L18;
        t1a.b r5 = s1a.a.g(r4);
        if (r5 == null) goto L18;
        va8.g0 r6 = r5.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r6 == null) goto L18;
        if (r6.YC() != true) goto L18;
    L19:
        if (r1 == false) goto L28;
        Fragment r7 = this.h;
        if (r7 == null) goto L36;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L37;
        va8.g0 r9 = r8.o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r9 == null) goto L38;
        r9.km("ai_doc_detail");
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L18:
        r1 = false;
    L28:
        vm9.d r10 = com.larus.office.base.service.m.b();
        if (r10 == null) goto L31;
        r2 = r10.onBackPressed(this.i);
    L31:
        if (r2 == true) goto L39;
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L40;
        r11.finish();
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (r0.isAdded() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void onDestroy() {
        if (this.e == true) goto L9;
        this.e = true;
        int r0 = com.larus.doc.impl.offline.k.a;
        String r1 = this.H;
        if (Intrinsics.areEqual(this.l, "answer_manual_create") == false) goto L7;
        String r2 = "send_message_create";
    L8:
        String r3 = r2;
        String r4 = this.f;
        String r5 = this.j;
        int r6 = ga0();
        int r7 = ga0();
        String r8 = ea0();
        JSONObject r9 = Da0();
        com.larus.doc.impl.offline.k.a(r1, r3, r4, r5, Integer.valueOf(r6), Integer.valueOf(r7), r8, r9, this);
        goto L9
    L7:
        r2 = this.l;
    L9:
        super.onDestroy();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ra0() {
        ViewGroup r0 = this.s;
        if (r0 == null) goto L48;
        FLogger.a.i("DocFragmentV2", "setupChatAndOpBarContainer");
        r0.removeAllViews();
        ConstraintLayout r1 = LayoutInflater.from(getContext()).inflate(2131562801, r0, false);
        r0.addView(r1);
        int r2 = 2131365539;
        View r3 = ViewBindings.findChildViewById(r1, 2131365539);
        if (r3 == null) goto L47;
        r2 = 2131369293;
        InterceptTouchFrameLayout r4 = (InterceptTouchFrameLayout) ViewBindings.findChildViewById(r1, 2131369293);
        if (r4 == null) goto L47;
        r2 = 2131369345;
        ViewStub r5 = (ViewStub) ViewBindings.findChildViewById(r1, 2131369345);
        if (r5 == null) goto L47;
        r2 = 2131379083;
        TextLoadingView r6 = ViewBindings.findChildViewById(r1, 2131379083);
        if (r6 == null) goto L47;
        this.t = r4;
        this.u = r6;
        com.larus.utils.e1.d(r6, new m1(this));
        this.v = r3;
        r3.setOnClickListener(new n1(this));
        int r7 = da0();
        if (r7 != 1) goto L15;
        int r8 = 2131562125;
    L19:
        r5.setLayoutResource(r8);
        this.q = r5.inflate();
        W90();
        View r9 = this.q;
        if (r9 == null) goto L22;
        com.larus.utils.e1.o(r9);
    L22:
        la0();
        if (da0() == 1) goto L29;
        View r10 = this.q;
        if (r10 == null) goto L29;
        View r11 = r10.findViewById(2131369311);
        if (r11 == null) goto L29;
        com.larus.utils.e1.d(r11, new o1(this));
    L29:
        View r12 = this.q;
        if (r12 == null) goto L35;
        View r13 = r12.findViewById(2131369314);
        if (r13 == null) goto L35;
        com.larus.utils.e1.d(r13, new p1(this));
    L35:
        if (canEdit() == true) goto L42;
        View r14 = this.q;
        if (r14 == null) goto L42;
        View r15 = r14.findViewById(2131369314);
        if (r15 == null) goto L42;
        r15.setAlpha(0.5f);
    L42:
        if (this.J2 == false) goto L49;
        DocFragment$initChatService$1 r16 = this.R;
        if (r16 == null) goto L50;
        r16.setChatInputVisibility(true);
        return;
    L50:
        return;
    L49:
        return;
    L15:
        if (r7 == 2) goto L17;
        r8 = 2131562124;
        goto L19
    L17:
        r8 = 2131562123;
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void xa0() {
        Aa0(10);
    }

    public DocFragmentV2() {
        this.N2 = LazyKt.lazy(new i1(this));
    }

    public final com.larus.office.base.component.permission.b X2() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 == null) goto L12;
        DocPermissionFullData r1 = r0.C4();
        if (r1 == null) goto L12;
        fo9.f r2 = r1.getOwner();
        if (r2 == null) goto L12;
        String r3 = r2.a;
        if (r3 == null) goto L12;
    L11:
        String r5 = r3;
    L31:
        return new com.larus.office.base.component.permission.b(this.f, this.C, r5, 22, this.l, this.A, this.z, this.y);
    L12:
        r3 = null;
        if (r0 == null) goto L19;
        DocPermissionFullData r4 = r0.C4();
        if (r4 == null) goto L19;
        fo9.f r6 = r4.getOwner();
        if (r6 == null) goto L19;
        String r7 = r6.b;
    L20:
        if (r7 != null) goto L29;
        if (r0 == null) goto L27;
        DocPermissionFullData r8 = r0.C4();
        if (r8 == null) goto L27;
        fo9.f r9 = r8.getOwner();
        if (r9 == null) goto L27;
        r3 = r9.c;
    L27:
        if (r3 != null) goto L11;
        r3 = "";
        goto L11
    L29:
        r5 = r7;
    L19:
        r7 = null;
        goto L20
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canCopy() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canCopy();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canEdit() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canEdit();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canRead() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canRead();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean canShare() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canShare();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void foldStatusChanged() {
        super.foldStatusChanged();
        Fragment r0 = this.h;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ViewGroup.MarginLayoutParams r3 = null;
        if (r1 == false) goto L35;
        Fragment r4 = this.h;
        if (r4 == null) goto L19;
        t1a.b r5 = s1a.a.g(r4);
        if (r5 == null) goto L19;
        va8.g0 r6 = r5.getAbility(va8.g0.class);
        if (r6 == null) goto L19;
        if (r6.YC() != true) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L35;
        LarusLayoutDocDetailFragmentBinding r8 = this.g;
        if (r8 == null) goto L26;
        FrameLayout r9 = r8.u;
        if (r9 == null) goto L26;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L28:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        r3 = (ViewGroup.MarginLayoutParams) r10;
    L30:
        if (r3 == null) goto L32;
        r3.topMargin = 0;
    L32:
        IDocSdkServiceV2 r11 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r11 == null) goto L53;
        r11.notifyChatInputFoldStatusChanged(false, Y90());
        return;
    L53:
        return;
    L26:
        r10 = null;
    L19:
        r7 = false;
    L35:
        LarusLayoutDocDetailFragmentBinding r12 = this.g;
        if (r12 == null) goto L40;
        FrameLayout r13 = r12.u;
        if (r13 == null) goto L40;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L42:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        r3 = (ViewGroup.MarginLayoutParams) r14;
    L44:
        if (r3 == null) goto L49;
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L48;
        r2 = com.larus.utils.u.c(r15);
    L48:
        r3.topMargin = r2;
    L49:
        IDocSdkServiceV2 r16 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r16 == null) goto L55;
        r16.notifyChatInputFoldStatusChanged(true, Y90());
        return;
    L55:
        return;
    L40:
        r14 = null;
        goto L42
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final Context getHostContext() {
        return getContext();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean isOwner() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOwner();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean p6() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.p6();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean s8() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.s8();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void sa0() {
        super.sa0();
        Ca0();
    }

    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    @Override // com.larus.doc.impl.DocFragment
    public final boolean y4() {
        com.larus.office.base.component.permission.a r0 = Ea0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.y4();
    }

    public final Fragment d5() {
        return this.i;
    }

    public final String getToken() {
        return this.f;
    }

    public final void d7(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (isAdded() == false) goto L6;
        r2.invoke();
        return;
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ha0(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DocFragmentV2$initFragment$1(r8, this, null), 3, null);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ka0(boolean r2) {
        Lazy r0 = com.larus.office.base.service.m.a;
        ym9.c r1 = com.larus.office.base.service.m.a(Y90());
        if (r1 == null) goto L6;
        r1.onEditPanelActive(r2);
        return;
    }

    public final void x5(Fragment r1) {
        this.i = r1;
    }

    public final Object V3(Context r20, Continuation<? super Fragment> r21) {
        if ((r21 instanceof DocFragmentV2$createOfficeFragment$1) == false) goto L7;
        DocFragmentV2$createOfficeFragment$1 r2 = (DocFragmentV2$createOfficeFragment$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DocFragmentV2$createOfficeFragment$1 r12 = r2;
        Object r1 = r12.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        boolean r6 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L122:
        return (Fragment) r1;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r7 = (String) r12.L$2;
        Context r8 = (Context) r12.L$1;
        IDocSdkServiceV2 r9 = (IDocSdkServiceV2) r12.L$0;
        ResultKt.throwOnFailure(r1);
        String r10 = r7;
        IDocSdkServiceV2 r11 = r9;
    L26:
        String r13 = (String) r1;
        Bundle r14 = getArguments();
        if (r14 == null) goto L29;
        String r15 = r14.getString("key_message_id");
    L30:
        Bundle r16 = getArguments();
        if (r16 == null) goto L33;
        Long r17 = Boxing.boxLong(r16.getLong("key_click_timestamp"));
    L34:
        OfficeInputParam r18 = new OfficeInputParam();
        r18.setResourceId(this.f);
        r18.setDocLogicKey(Y90());
        r18.setResourceType(this.m);
        Bundle r22 = getArguments();
        String r110 = "";
        if (r22 == null) goto L38;
        String r23 = r22.getString("artifact_meta_id");
        if (r23 == null) goto L38;
    L39:
        r18.setArtifactMetaId(r23);
        Bundle r24 = getArguments();
        if (r24 == null) goto L43;
        String r25 = r24.getString("argConversationId");
        if (r25 == null) goto L43;
    L44:
        r18.setConversationId(r25);
        Bundle r26 = getArguments();
        if (r26 == null) goto L47;
        long r111 = r26.getLong("key_click_timestamp");
    L48:
        Context r27 = r8;
        r18.setClickTimestamp(r111);
        r18.setBeginLoadTimestamp(System.currentTimeMillis());
        String r28 = this.l;
        if (r28 != null) goto L51;
        r28 = "";
    L51:
        r18.setEnterMethod(r28);
        r18.setDocTitle(this.C);
        Bundle r30 = getArguments();
        if (r30 == null) goto L54;
        boolean r31 = r30.getBoolean("has_report_finish_event");
    L55:
        r18.setHasReportFinishEvent(r31);
        Bundle r32 = getArguments();
        if (r32 != null) goto L58;
    L60:
        boolean r33 = false;
    L61:
        r18.setColdStart(r33);
        Bundle r34 = getArguments();
        if (r34 == null) goto L64;
        String r35 = r34.getString("argPreviousPage");
    L65:
        r18.setPreviousPage(r35);
        r18.setApplyPermissionConversationId(this.z);
        r18.setApplyPermissionMessageId(this.A);
        r18.setObjType(Boxing.boxInt(22));
        Bundle r36 = getArguments();
        if (r36 == null) goto L68;
        String r37 = r36.getString("feishu_record_id");
    L69:
        r18.setFeishuRecordId(r37);
        Bundle r38 = getArguments();
        if (r38 == null) goto L72;
        String r40 = r38.getString("feishu_record_generated_type");
    L73:
        r18.setFeishuRecordContentType(r40);
        Bundle r41 = getArguments();
        if (r41 == null) goto L76;
        String r42 = r41.getString("record_scene");
    L77:
        r18.setRecordScene(r42);
        Bundle r43 = getArguments();
        if (r43 == null) goto L80;
        String r44 = r43.getString("is_general_agent");
    L81:
        if (r44 != null) goto L83;
    L86:
        boolean r45 = true;
    L88:
        if (Boxing.boxBoolean(!r45).booleanValue() == true) goto L91;
        r44 = null;
    L91:
        if (r44 != null) goto L93;
        r44 = "0";
    L93:
        r18.setGeneralAgent(r44);
        Bundle r46 = getArguments();
        if (r46 == null) goto L96;
        String r47 = r46.getString("chat_id");
    L97:
        if (r47 == null) goto L100;
        r110 = r47;
    L100:
        r18.setAgentChatId(r110);
        Bundle r48 = getArguments();
        if (r48 != null) goto L103;
    L105:
        boolean r50 = false;
    L106:
        r18.setDocPreloaded(r50);
        r18.setOfflineCreateAttemptId(this.H);
        r18.setFakeOfflineDoc(Intrinsics.areEqual(this.f, "fake_offline_doc_id"));
        Bundle r51 = getArguments();
        if (r51 == null) goto L109;
        String r52 = r51.getString("key_source_url_for_params");
    L110:
        r18.setSourceUrlForParams(r52);
        Bundle r53 = getArguments();
        if (r53 != null) goto L113;
    L115:
        r6 = false;
    L116:
        r18.setOpenChatWithNewLocalConv(r6);
        Unit r54 = Unit.INSTANCE;
        com.larus.office.base.component.permission.a r112 = this.M2;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 2;
        r1 = r11.openAndGetDocFragment(r27, r10, r13, r15, r17, r18, r112, null, r12);
        if (r1 != r4) goto L122;
        return r4;
    L113:
        if (r53.getBoolean("open_chat_with_new_local_conv", false) != true) goto L115;
    L109:
        r52 = null;
        goto L110
    L103:
        if (r48.getBoolean("key_office_preloaded", false) != true) goto L105;
        r50 = true;
        goto L106
    L96:
        r47 = null;
        goto L97
    L83:
        if (r44.length() == 0) goto L86;
        r45 = false;
        goto L88
    L80:
        r44 = null;
        goto L81
    L76:
        r42 = null;
        goto L77
    L72:
        r40 = null;
        goto L73
    L68:
        r37 = null;
        goto L69
    L64:
        r35 = null;
        goto L65
    L58:
        if (r32.getBoolean("is_cold_start") != true) goto L60;
        r33 = true;
        goto L61
    L54:
        r31 = false;
        goto L55
    L47:
        r111 = System.currentTimeMillis();
    L43:
        r25 = "";
    L38:
        r23 = "";
        goto L39
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L16:
        ResultKt.throwOnFailure(r1);
        Ca0();
        IDocSdkServiceV2 r55 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r55 == null) goto L121;
        String r56 = this.f;
        DocUtils r57 = DocUtils.a;
        Bundle r58 = getArguments();
        if (r58 == null) goto L21;
        String r60 = r58.getString("key_message_id");
    L22:
        r12.L$0 = r55;
        r12.L$1 = r20;
        r12.L$2 = r56;
        r12.label = 1;
        Object r61 = r57.b(r56, r60, r12);
        if (r61 != r4) goto L25;
        return r4;
    L25:
        r10 = r56;
        r11 = r55;
        r1 = r61;
        r8 = r20;
        goto L26
    L21:
        r60 = null;
        goto L22
    L121:
        return null;
    L7:
        r2 = new DocFragmentV2$createOfficeFragment$1(this, r21);
        goto L8
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
    }

    @Override // com.larus.doc.impl.DocFragment
    public final void ya0(boolean r1, boolean r2) {
        super.ya0(r1, r2);
        if (r2 == true) goto L5;
        return;
    L5:
        if (this.r == false) goto L9;
        la0();
        return;
    }

    @Override // com.larus.doc.impl.DocFragment, g39.a
    public final void F8(String r10, String r11, String r12, String r13) {
        FLogger.a.i("DocFragmentV2", "updateArtifactId, artifactId = " + r10);
        this.j = r10;
        this.k = r11;
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.x = r12;
        this.w = r13;
        if (r10 == null) goto L9;
        String r14 = m39.a.a;
        Intrinsics.checkNotNullParameter(r10, "artifactId");
        m39.a.b = r10;
    L9:
        if (this.e == true) goto L16;
        this.e = true;
        int r15 = com.larus.doc.impl.offline.k.a;
        String r0 = this.H;
        if (Intrinsics.areEqual(this.l, "answer_manual_create") == false) goto L13;
        String r16 = "send_message_create";
    L14:
        String r1 = r16;
        String r2 = this.f;
        int r17 = ga0();
        int r18 = ga0();
        com.larus.doc.impl.offline.k.a(r0, r1, r2, r10, Integer.valueOf(r17), Integer.valueOf(r18), ea0(), Da0(), this);
        return;
    L13:
        r16 = this.l;
        goto L14
    }
}
