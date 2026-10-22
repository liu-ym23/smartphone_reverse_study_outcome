package com.larus.sheet.operation.share.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.sheet.biz.impl.databinding.LarusPageSheetPermissionSettingsBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/sheet/operation/share/view/SheetPermissionSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/sheet/biz/impl/databinding/LarusPageSheetPermissionSettingsBinding;", "currentPrivacyStatus", "", "currentSheetToken", "", "aipptTaskId", "presentationId", "resourceId", "resourceType", "", "Ljava/lang/Integer;", "artifactMetaId", "artifactType", "isUpdatingFromCode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "onViewCreated", "view", "setupViews", "updatePermissionPublic", "updatePermissionPrivate", "autoLogEnterPage", "getCurrentPageName", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetPermissionSettingFragment extends TraceFragment {
    public static final /* synthetic */ int o = 0;
    public LarusPageSheetPermissionSettingsBinding e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public String l;
    public Integer m;
    public boolean n;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final void T90() {
    }

    public final String k() {
        return "aippt_permission_setting";
    }

    public SheetPermissionSettingFragment() {
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.l = "";
    }

    public final void onCreate(Bundle r60) {
        super.onCreate(r60);
        Bundle r1 = getArguments();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.getBoolean("slides_permission") != true) goto L7;
    L8:
        this.f = r2;
        Bundle r3 = getArguments();
        String r4 = "";
        if (r3 == null) goto L12;
        String r5 = r3.getString("sheets_token");
        if (r5 == null) goto L12;
    L13:
        this.g = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L17;
        String r7 = r6.getString("aippt_task_id");
        if (r7 == null) goto L17;
    L18:
        this.h = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L22;
        String r9 = r8.getString("spreadsheet_id");
        if (r9 == null) goto L22;
    L23:
        this.i = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L27;
        String r11 = r10.getString("resource_id");
        if (r11 == null) goto L27;
    L28:
        this.j = r11;
        Bundle r12 = getArguments();
        Integer r13 = null;
        if (r12 == null) goto L31;
        Integer r14 = Integer.valueOf(r12.getInt("resource_type"));
    L32:
        this.k = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L38;
        String r16 = r15.getString("artifact_meta_id");
        if (r16 == null) goto L38;
        r4 = r16;
    L38:
        this.l = r4;
        Bundle r17 = getArguments();
        if (r17 == null) goto L41;
        r13 = Integer.valueOf(r17.getInt("artifact_type"));
    L41:
        this.m = r13;
        a1.c(null, null, null, null, null, "aippt_permission_setting", null, null, "aippt_new_detail_share_panel", null, null, null, null, null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.l, r13, null, null, null, null, this.h, this.i, this.j, this.k, null, null, null, null, null, null, null, null, null, -1049729, -7876609, 7);
        return;
    L31:
        r14 = null;
    L27:
        r11 = "";
    L22:
        r9 = "";
    L17:
        r7 = "";
    L12:
        r5 = "";
    L7:
        r2 = false;
        goto L8
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusPageSheetPermissionSettingsBinding r10 = this.e;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.c;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, r0.getResources().getString(2131909793), 2131103136, null, 4);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.sheet.operation.share.view.a(this), 14);
    L7:
        LarusPageSheetPermissionSettingsBinding r11 = this.e;
        if (r11 == null) goto L14;
        ItemTextToggle r12 = r11.b;
        if (r12 == null) goto L14;
        CustomSwitchCompat r13 = r12.getToggleView();
        if (r13 == null) goto L14;
        r13.setChecked(this.f);
    L14:
        LarusPageSheetPermissionSettingsBinding r14 = this.e;
        if (r14 == null) goto L22;
        ItemTextToggle r15 = r14.b;
        if (r15 == null) goto L23;
        CustomSwitchCompat r16 = r15.getToggleView();
        if (r16 == null) goto L24;
        r16.setOnCheckedChangeListener(new b(this));
        return;
    L24:
        return;
    L23:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        FLogger.a.i("SheetPermissionSettingFragment", "[onCreateView]");
        ConstraintLayout r6 = r3.inflate(2131563072, r4, false);
        int r7 = 2131386186;
        ItemTextToggle r8 = ViewBindings.findChildViewById(r6, 2131386186);
        if (r8 == null) goto L11;
        r7 = 2131388559;
        if (ViewBindings.findChildViewById(r6, 2131388559) == null) goto L11;
        r7 = 2131388807;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r6, 2131388807);
        if (r0 == null) goto L11;
        ConstraintLayout r9 = r6;
        this.e = new LarusPageSheetPermissionSettingsBinding(r9, r8, r0);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
