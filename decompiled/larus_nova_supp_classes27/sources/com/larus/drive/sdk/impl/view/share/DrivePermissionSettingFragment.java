package com.larus.drive.sdk.impl.view.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.drive.sdk.impl.databinding.LarusPageDrivePermissionSettingsBinding;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/drive/sdk/impl/view/share/DrivePermissionSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusPageDrivePermissionSettingsBinding;", "currentPrivacyStatus", "", "currentFileToken", "", "currentFileType", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "setupViews", "updatePermission", "public", "getCurrentPageName", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePermissionSettingFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusPageDrivePermissionSettingsBinding e;
    public boolean f;
    public String g;
    public int h;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "page_drive_permission_settings";
    }

    public DrivePermissionSettingFragment() {
        this.g = "";
        this.h = 12;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        this.f = r0;
        if (r5 == null) goto L11;
        String r1 = r5.getString("drive_file_token");
        if (r1 == null) goto L11;
    L12:
        this.g = r1;
        if (r5 == null) goto L15;
        int r6 = r5.getInt("drive_file_type");
    L16:
        this.h = r6;
        return;
    L15:
        r6 = 12;
    L11:
        r1 = "";
        goto L12
    L5:
        if (r5.getBoolean("privacy_status") != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusPageDrivePermissionSettingsBinding r10 = this.e;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.c;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, r0.getResources().getString(2131909793), 2131103136, null, 4);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.drive.sdk.impl.view.share.a(this), 14);
    L7:
        LarusPageDrivePermissionSettingsBinding r11 = this.e;
        if (r11 == null) goto L14;
        ItemTextToggle r12 = r11.b;
        if (r12 == null) goto L14;
        CustomSwitchCompat r13 = r12.getToggleView();
        if (r13 == null) goto L14;
        r13.setChecked(this.f);
    L14:
        LarusPageDrivePermissionSettingsBinding r14 = this.e;
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

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131563041, r3, false);
        int r6 = 2131370294;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r5, 2131370294);
        if (r7 == null) goto L11;
        r6 = 2131388559;
        if (ViewBindings.findChildViewById(r5, 2131388559) == null) goto L11;
        r6 = 2131388807;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131388807);
        if (r0 == null) goto L11;
        ConstraintLayout r8 = r5;
        this.e = new LarusPageDrivePermissionSettingsBinding(r8, r7, r0);
        return r8;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
