package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.drive.sdk.impl.databinding.LarusLayoutDrivePreviewFileFragmentBinding;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer;
import com.larus.drive.sdk.impl.viewmodel.preview.DrivePreviewViewModel;
import com.larus.platform.exp.o;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0006\u0010%\u001a\u00020\"J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020 H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusLayoutDrivePreviewFileFragmentBinding;", "viewModel", "Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "getViewModel", "()Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "floatChatContainer", "Lcom/larus/drive/sdk/impl/view/chat/DriveFloatChatContainer;", "contentContainer", "Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewContentContainer;", "conversationId", "", "driveFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "previewFromPage", "Lcom/larus/drive/sdk/api/meta/PreviewFromPage;", "getCurrentPageName", "autoLogEnterPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onBackPressed", "initHostFragment", "initConfig", "refreshPreviewPermission", "initTopContainer", "initContentContainer", "initFloatChatContainer", "getParamsBundle", "handleDrivePreviewSendMsg", "sendText", "isSpeak", "buildMoreMenu", "anchorView", "adjustPreviewContentBottomMargin", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewFragment extends TraceFragment {
    public static final /* synthetic */ int l = 0;
    public LarusLayoutDrivePreviewFileFragmentBinding e;
    public final Lazy f;
    public DriveFloatChatContainer g;
    public e h;
    public String i;
    public DriveFileItem j;
    public PreviewFromPage k;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "ai_space_detail";
    }

    public final void onDestroyView() {
        e r0 = this.h;
        if (r0 == null) goto L13;
        Fragment r2 = r0.e;
        if (r2 != null) goto L7;
    L12:
        r0.e = null;
        goto L13
    L7:
        if (r2.isAdded() == false) goto L12;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        r0.a.getChildFragmentManager().beginTransaction().remove(r2).commitNowAllowingStateLoss();     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        this.h = null;
        DriveFloatChatContainer r1 = this.g;
        if (r1 == null) goto L53;
        r1.h++;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[detach] start, fragmentTag=");
        r6.append(r1.b);
        r6.append(", containerId=");
        r6.append(r1.c);
        r6.append(", fragmentAdded=");
        Fragment r7 = r1.f;
        if (r7 != null) goto L18;
    L20:
        boolean r8 = false;
    L21:
        r6.append(r8);
        r5.i("DriveFloatChatContainer", r6.toString());
        r1.b("[detach] provider before clear");
        DriveFloatChatContainer.c r9 = r1.g;
        if (r9 == null) goto L26;
        g0 r10 = r9.b();
        if (r10 == null) goto L26;
        r10.Zh(r1.k);
    L26:
        DriveFloatChatContainer.c r11 = r1.g;
        if (r11 == null) goto L31;
        r79.b r12 = r11.e();
        if (r12 == null) goto L31;
        r12.az(false);
    L31:
        DriveFloatChatContainer.c r13 = r1.g;
        if (r13 == null) goto L36;
        ICoreInputAbility r14 = r13.v0();
        if (r14 == null) goto L36;
        r14.p80(true);
        r14.tr(new com.larus.drive.sdk.impl.view.chat.a());
    L36:
        DriveFloatChatContainer.c r15 = r1.g;
        if (r15 == null) goto L41;
        l r16 = r15.c();
        if (r16 == null) goto L41;
        r16.b3(new com.larus.drive.sdk.impl.view.chat.b());
        r16.B9(r1.l);
    L41:
        Fragment r17 = r1.f;
        if (r17 != null) goto L55;
        r5.i("DriveFloatChatContainer", "[detach] skip remove, fragment is null");
    L52:
        r1.g = null;
        r1.f = null;
        FLogger.a.i("DriveFloatChatContainer", "[detach] finish, fragmentTag=" + r1.b + ", containerId=" + r1.c);
        goto L53
    L55:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L45
        Object r20 = Result.constructor-impl(Integer.valueOf(r1.a.getChildFragmentManager().beginTransaction().remove(r17).commitAllowingStateLoss()));     // Catch: Throwable -> L45
    L47:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L50;
        FLogger.a.e("DriveFloatChatContainer", "[detach] remove fragment failed, fragmentTag=" + r1.b + ", containerId=" + r1.c, r21);
    L50:
        Result.box-impl(r20);
    L45:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L18:
        if (r7.isAdded() != true) goto L20;
        r8 = true;
    L53:
        this.g = null;
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DrivePreviewFragment() {
        final Function0<Fragment> r0 = new DrivePreviewFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DrivePreviewViewModel.class), new DrivePreviewFragment$special$$inlined$viewModels$default$2(r0), new DrivePreviewFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = "";
        this.k = PreviewFromPage.UNKNOWN;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        String r10 = "";
        String r0 = null;
        if (o.a() == true) goto L10;
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L8;
        String r12 = r11.a;
    L9:
        if (r12 == null) goto L10;
    L11:
        this.i = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L14;
        DriveFileItem r14 = (DriveFileItem) r13.getParcelable("drive_file");
    L15:
        this.j = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L28;
        String r16 = r15.getString("drive_preview_from_page");
        if (r16 == null) goto L28;
        Iterator r1 = PreviewFromPage.getEntries().iterator();
    L21:
        if (r1.hasNext() == false) goto L25;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((PreviewFromPage) r2).getValue(), r16) == false) goto L21;
    L26:
        PreviewFromPage r3 = (PreviewFromPage) r2;
        if (r3 == null) goto L28;
    L29:
        this.k = r3;
        DriveFileItem r17 = this.j;
        boolean r4 = true;
        if (r17 == null) goto L38;
        String r5 = r17.b;
        if (r5.length() != 0) goto L34;
        boolean r6 = true;
    L35:
        if (r6 == false) goto L37;
        FLogger.a.i("DrivePreviewFragment", "[refreshPreviewPermission] invalid fileToken");
        goto L38
    L37:
        t.a().p(r5, r17.d, null);
        goto L38
    L34:
        r6 = false;
    L38:
        final LarusLayoutDrivePreviewFileFragmentBinding r18 = this.e;
        if (r18 == null) goto L57;
        ConstraintLayout r7 = r18.h;
        ViewGroup.LayoutParams r20 = r7.getLayoutParams();
        if ((r20 instanceof ConstraintLayout.LayoutParams) == false) goto L43;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
    L44:
        if (r21 == null) goto L50;
        FragmentActivity r22 = getActivity();
        if (r22 == null) goto L48;
        int r23 = u.c(r22);
    L49:
        ((ViewGroup.MarginLayoutParams) r21).topMargin = r23;
    L51:
        r7.setLayoutParams(r21);
        TextView r24 = r18.g;
        DriveFileItem r25 = this.j;
        if (r25 == null) goto L54;
        String r26 = r25.a;
    L55:
        r24.setText(r26);
        e1.d(r18.b, new f(this));
        e1.d(r18.f, new g(this, r18));
        goto L57
    L54:
        r26 = null;
        goto L55
    L48:
        r23 = 0;
        goto L49
    L50:
        r21 = null;
        goto L51
    L43:
        r21 = null;
    L57:
        if (this.h == null) goto L59;
        FLogger.a.i("DrivePreviewFragment", "[initContentContainer] Already init");
    L98:
        if (this.g == null) goto L100;
        FLogger.a.i("DrivePreviewFragment", "[initFloatChatFragment] Already init");
    L117:
        LarusLayoutDrivePreviewFileFragmentBinding r27 = this.e;
        if (r27 == null) goto L126;
        FrameLayout r28 = r27.c;
        if (r28 == null) goto L127;
        r28.postDelayed(new h(this), 500);
        return;
    L127:
        return;
    L126:
        return;
    L100:
        DriveFileItem r30 = this.j;
        if (r30 == null) goto L103;
        r0 = r30.d(false);
    L103:
        if (r0 == null) goto L107;
        r10 = r0;
    L107:
        if (UploadFilePolicy.e(r10) == true) goto L109;
        FLogger.a.i("DrivePreviewFragment", "[initFloatChatFragment] This file postFix=" + r10 + " is not support input");
        goto L117
    L109:
        DriveFileItem r31 = this.j;
        if (r31 == null) goto L112;
        long r32 = r31.e();
    L114:
        if (UploadFilePolicy.f(r32) == true) goto L116;
        FLogger.a.i("DrivePreviewFragment", "[initFloatChatFragment] This file size=" + r32 + " is not support input");
        goto L117
    L116:
        DriveFloatChatContainer r33 = new DriveFloatChatContainer(this, new DrivePreviewFragment$initFloatChatContainer$1(this), new k(this));
        this.g = r33;
        r33.a();
        goto L117
    L112:
        r32 = 0;
        goto L114
    L59:
        e r34 = new e(this, this.j);
        this.h = r34;
        if (r34.e == null) goto L63;
        FLogger.a.i("DrivePreviewContentContainer", "[attach] Already attached");
        goto L98
    L63:
        if (r34.a.isAdded() == true) goto L65;
        FLogger.a.i("DrivePreviewContentContainer", "[attach] Parent not added");
        goto L98
    L65:
        DriveFileItem r35 = r34.c;
        if (r35 == null) goto L68;
        String r36 = r35.b;
    L69:
        if (r36 != null) goto L71;
        r36 = "";
    L71:
        String r37 = StringsKt.trim(r36).toString();
        if ((!StringsKt.isBlank(r37)) == false) goto L74;
        String r38 = "https://feishu.doubao.com/file/" + r37;
    L76:
        if ((!StringsKt.isBlank(r38)) == false) goto L78;
        Fragment r40 = t.b().d(r38);
    L79:
        if (r40 != null) goto L81;
        r40 = new DrivePreviewContentFragment();
    L81:
        r34.e = r40;
        FragmentTransaction r41 = r34.a.getChildFragmentManager().beginTransaction();
        String r42 = r34.d;
        if (r42 != null) goto L84;
    L87:
        if (r4 == false) goto L92;
        int r43 = r34.b;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r41, r40, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r43) == true) goto L96;
        r41.replace(r43, r40);
    L96:
        r41.commitNowAllowingStateLoss();
        goto L98
    L92:
        int r44 = r34.b;
        String r45 = r34.d;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r41, r40, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r45, r44) == true) goto L96;
        r41.replace(r44, r40, r45);
        goto L96
    L84:
        if (StringsKt.isBlank(r42) == true) goto L87;
        r4 = false;
        goto L87
    L78:
        r40 = null;
        goto L79
    L74:
        r38 = "";
        goto L76
    L68:
        r36 = null;
        goto L69
    L25:
        r2 = null;
    L28:
        r3 = PreviewFromPage.UNKNOWN;
        goto L29
    L14:
        r14 = null;
        goto L15
    L8:
        r12 = null;
    L10:
        r12 = "";
        goto L11
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562810, r11, false);
        int r14 = 2131370302;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r13, 2131370302);
        if (r2 == null) goto L19;
        r14 = 2131370306;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131370306);
        if (r3 == null) goto L19;
        r14 = 2131370307;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131370307);
        if (r4 == null) goto L19;
        r14 = 2131370308;
        View r5 = ViewBindings.findChildViewById(r13, 2131370308);
        if (r5 == null) goto L19;
        r14 = 2131370311;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, 2131370311);
        if (r6 == null) goto L19;
        r14 = 2131370314;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131370314);
        if (r7 == null) goto L19;
        r14 = 2131370315;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r13, 2131370315);
        if (r8 == null) goto L19;
        ConstraintLayout r15 = r13;
        this.e = new LarusLayoutDrivePreviewFileFragmentBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
