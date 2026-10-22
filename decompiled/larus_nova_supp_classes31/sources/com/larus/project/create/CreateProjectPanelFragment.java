package com.larus.project.create;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import be8.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.bmhome.taskskill.service.j;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFlowskillFragmentCreateProjectPanelBinding;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.v0;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ls9.e;
import ls9.f;
import ls9.g;
import ls9.h;
import ls9.i;
import org.json.JSONObject;
import tx9.p3;
import v19.i5;
import v19.s5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u001eH\u0002J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006A"}, d2 = {"Lcom/larus/project/create/CreateProjectPanelFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFlowskillFragmentCreateProjectPanelBinding;", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "selectedDevice", "Lcom/larus/bmhome/chat/component/skill/TaskDeviceInfo;", "selectedFolderName", "", "selectedFolderPath", "shouldReportAddFolderResult", "", "isWaitingForFolderResult", "hasSubmitted", "isUserCanceled", "contentBottomPadding", "fragmentResultKey", "getFragmentResultKey$impl_mainlandRelease", "()Ljava/lang/String;", "autoLaunchDevicePicker", "getAutoLaunchDevicePicker", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onPause", "onDestroyView", "updateCreateEnabled", "openDevicePicker", "openFolderPicker", "device", "reportAddProjectFolderResult", "addResult", "renderFolderRow", "softInputAdjustMode", "setupImeInsets", "root", "updateImeBottomPadding", "insets", "Landroidx/core/view/WindowInsetsCompat;", "showProjectNameKeyboard", "hideProjectNameKeyboard", "submit", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreateProjectPanelFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public LarusFlowskillFragmentCreateProjectPanelBinding d;
    public d e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ CreateProjectPanelFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(CreateProjectPanelFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            CreateProjectPanelFragment r3 = this.a;
            int r0 = CreateProjectPanelFragment.m;
            r3.ba0();
        }
    }

    public static final class c implements IPcDevicePanelService.a {
        public final /* synthetic */ CreateProjectPanelFragment a;

        public final void a() {
            CreateProjectPanelFragment r0 = this.a;
            if (r0.i == true) goto L6;
            r0.aa0("cancel");
            return;
        }

        public final void c() {
            CreateProjectPanelFragment r0 = this.a;
            r0.e = null;
            r0.f = null;
            r0.g = null;
            r0.Z90();
            this.a.aa0("cancel");
        }

        public c(CreateProjectPanelFragment r1) {
            this.a = r1;
        }

        public final void b(d r8) {
            Intrinsics.checkNotNullParameter(r8, "device");
            FLogger r0 = FLogger.a;
            r0.i("CreateProjectPanel", "onPcDeviceSelected id=" + r8.a);
            CreateProjectPanelFragment r1 = this.a;
            r1.e = r8;
            r1.f = null;
            r1.g = null;
            r1.Z90();
            CreateProjectPanelFragment r2 = this.a;
            boolean r3 = true;
            r2.i = true;
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            if (r2.getChildFragmentManager().isStateSaved() == true) goto L24;
            String r9 = r8.a;
            if (r9 == null) goto L14;
            if (r9.length() == 0) goto L14;
            r3 = false;
        L14:
            if (r3 == false) goto L16;
            r0.w("CreateProjectPanel", "openFolderPicker: empty deviceId");
            r2.aa0("fail");
            return;
        L16:
            IPcDevicePanelService r4 = (IPcDevicePanelService) ServiceManager.get().getService(IPcDevicePanelService.class);
            if (r4 != null) goto L19;
            r0.w("CreateProjectPanel", "openFolderPicker: IPcDevicePanelService not found");
            r2.aa0("fail");
            return;
        L19:
            r4.b(r2, r9, new IPcDevicePanelService.c(false), new i(r2));
            return;
        }
    }

    static {
    }

    public final int S90() {
        return 2131240754;
    }

    public final void Z90() {
        LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (this.f != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        LinearLayout r3 = r0.f;
        if (r1 == true) goto L15;
        r2 = 8;
    L15:
        r3.setVisibility(r2);
        TextView r4 = r0.h;
        String r5 = this.f;
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r4.setText(r5);
        return;
    L8:
        if (this.g == null) goto L10;
        r1 = true;
        goto L11
    }

    public final void ba0() {
        LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        Editable r1 = r0.c.getText();
        if (r1 == null) goto L10;
        String r2 = r1.toString();
        if (r2 == null) goto L10;
        String r3 = StringsKt.trim(r2).toString();
    L12:
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        boolean r5 = !r4;
        r0.g.setEnabled(r5);
        TextView r6 = r0.g;
        if (r5 == false) goto L21;
        float r7 = 1.0f;
    L22:
        r6.setAlpha(r7);
        return;
    L21:
        r7 = 0.3f;
        goto L22
    L14:
        if (r3.length() == 0) goto L17;
        r4 = false;
    L10:
        r3 = null;
        goto L12
    }

    public final void onDestroyView() {
        LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        if (r0 == null) goto L7;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(r1, null);
        ViewCompat.setWindowInsetsAnimationCallback(r1, null);
    L7:
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final int U90() {
        return i5.E();
    }

    public final String X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L12;
        String r1 = r0.getString("result_key");
        if (r1 == null) goto L12;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return "project_create_panel_service_result";
    }

    public final void Y90() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getChildFragmentManager().isStateSaved() == true) goto L32;
        LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        String r2 = null;
        if (r0 == null) goto L22;
        EditText r1 = r0.c;
        if (r1 == null) goto L22;
        Context r3 = getContext();
        if (r3 == null) goto L15;
        Object r4 = r3.getSystemService("input_method");
    L17:
        if ((r4 instanceof InputMethodManager) == false) goto L19;
        InputMethodManager r5 = (InputMethodManager) r4;
    L20:
        if (r5 == null) goto L22;
        r5.hideSoftInputFromWindow(r1.getWindowToken(), 0);
        goto L22
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = null;
    L22:
        IPcDevicePanelService r6 = (IPcDevicePanelService) ServiceManager.get().getService(IPcDevicePanelService.class);
        if (r6 != null) goto L26;
        FLogger.a.w("CreateProjectPanel", "openDevicePicker: IPcDevicePanelService not found");
        aa0("fail");
        return;
    L26:
        d r7 = this.e;
        if (r7 == null) goto L29;
        r2 = r7.a;
    L29:
        r6.a(this, r2, new IPcDevicePanelService.d(2131906225, 2131240901, 28, false), new c(this));
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        boolean r0 = s5.a;
        s5.a = false;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        boolean r0 = s5.a;
        s5.a = true;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L20;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L9;
        int r3 = 48;
    L10:
        Bundle r4 = getArguments();
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        int r6 = 3;
    L19:
        r1.setSoftInputMode(r3 | r6);
        goto L20
    L18:
        r6 = 5;
        goto L19
    L13:
        if (r4.getBoolean("auto_launch_device_picker") != true) goto L15;
        r5 = true;
        goto L16
    L9:
        r3 = 16;
    L20:
        BottomSheetDialog r2 = getDialog();
        if ((r2 instanceof BottomSheetDialog) == false) goto L23;
        BottomSheetDialog r7 = r2;
    L24:
        if (r7 == null) goto L33;
        View r8 = r7.findViewById(2131368870);
        if (r8 == null) goto L34;
        BottomSheetBehavior r9 = BottomSheetBehavior.from(r8);
        r9.setSkipCollapsed(true);
        r9.setState(3);
        LarusFlowskillFragmentCreateProjectPanelBinding r10 = this.d;
        if (r10 == null) goto L35;
        LinearLayout r11 = r10.a;
        if (r11 == null) goto L36;
        ViewCompat.requestApplyInsets(r11);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L23:
        r7 = null;
        goto L24
    }

    public CreateProjectPanelFragment() {
    }

    public final void W90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        if (this.k == true) goto L5;
    L14:
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r6);
        return;
    L5:
        if (this.j == true) goto L14;
        FragmentManager r0 = getParentFragmentManager();
        String r1 = X90();
        Bundle r2 = new Bundle();
        r2.putBoolean("is_cancel", true);
        String r3 = this.g;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        r2.putBoolean("is_bind_folder", !r4);
        Unit r5 = Unit.INSTANCE;
        r0.setFragmentResult(r1, r2);
        goto L14
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    }

    public final void aa0(String r4) {
        if (this.h == true) goto L5;
        return;
    L5:
        this.h = false;
        this.i = false;
        Intrinsics.checkNotNullParameter(r4, "addResult");
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        r0.put("platform", "app");
        r0.put("add_result", r4);
        p3.a("add_project_folder", r0, null);
    }

    public final void ca0(WindowInsetsCompat r5) {
        LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        if (r0 == null) goto L12;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L13;
        int r2 = r5.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        int r6 = r5.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r3 = this.l + RangesKt.coerceAtLeast(r2 - r6, 0);
        if (r1.getPaddingBottom() != r3) goto L10;
        return;
    L10:
        r1.setPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r3);
        return;
    L13:
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.k = true;
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
    }

    public final void onDismiss(DialogInterface r2) {
        W90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        final LarusFlowskillFragmentCreateProjectPanelBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        this.l = r0.a.getPaddingBottom();
        LinearLayout r1 = r0.a;
        if (Build.VERSION.SDK_INT < 30) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(r1, new h(this));
        ViewCompat.setWindowInsetsAnimationCallback(r1, new CreateProjectPanelFragment$setupImeInsets$2(this));
    L9:
        boolean r2 = true;
        r0.c.setFilters((InputFilter[]) new j[]{new j()});
        r0.c.requestFocus();
        AppCompatImageView r3 = r0.d;
        if (z2.a.b4().d == false) goto L12;
        int r4 = 0;
    L13:
        r3.setVisibility(r4);
        int r5 = v0.a;
        v0.a(r0.d, 28, 0, 0, 0);
        e1.d(r0.e, new ls9.a(this));
        e1.d(r0.d, new ls9.b(this));
        r0.c.addTextChangedListener(new b(this));
        e1.d(r0.b, new ls9.c(this));
        e1.d(r0.g, new ls9.d(this));
        r0.c.setOnEditorActionListener(new e(r0));
        Z90();
        ba0();
        if (r8 != null) goto L23;
        Bundle r9 = getArguments();
        if (r9 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == false) goto L23;
    L24:
        if (r2 == false) goto L26;
        r7.post(new f(this));
        return;
    L26:
        r0.c.post(new g(this));
        return;
    L18:
        if (r9.getBoolean("auto_launch_device_picker") != true) goto L20;
        r10 = true;
    L23:
        r2 = false;
        goto L24
    L12:
        r4 = 8;
        goto L13
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131562341, r11, false);
        int r14 = 2131366859;
        ConstraintLayout r2 = ViewBindings.findChildViewById(r13, 2131366859);
        if (r2 == null) goto L33;
        r14 = 2131366866;
        if (ViewBindings.findChildViewById(r13, 2131366866) == null) goto L33;
        r14 = 2131366879;
        if (ViewBindings.findChildViewById(r13, 2131366879) == null) goto L33;
        r14 = 2131371805;
        EditText r3 = (EditText) ViewBindings.findChildViewById(r13, 2131371805);
        if (r3 == null) goto L33;
        r14 = 2131375971;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r13, 2131375971);
        if (r4 == null) goto L33;
        r14 = 2131376107;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r13, 2131376107);
        if (r5 == null) goto L33;
        r14 = 2131376254;
        if (ViewBindings.findChildViewById(r13, 2131376254) == null) goto L33;
        r14 = 2131376255;
        if (ViewBindings.findChildViewById(r13, 2131376255) == null) goto L33;
        r14 = 2131376425;
        if (ViewBindings.findChildViewById(r13, 2131376425) == null) goto L33;
        r14 = 2131378742;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131378742);
        if (r6 == null) goto L33;
        r14 = 2131390458;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131390458);
        if (r7 == null) goto L33;
        r14 = 2131390644;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131390644);
        if (r8 == null) goto L33;
        r14 = 2131390904;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131390904)) == null) goto L33;
        r14 = 2131391076;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131391076)) == null) goto L33;
        LinearLayout r15 = (LinearLayout) r13;
        this.d = new LarusFlowskillFragmentCreateProjectPanelBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
