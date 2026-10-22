package com.ss.android.lark.officewebview.quality.safe.permission;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class PermissionHostFragment extends Fragment implements b {
    public static final /* synthetic */ int f = 0;
    public final c d;
    public final a e;

    public PermissionHostFragment() {
        this.d = new c();
        this.e = new a();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.a = null;
        this.e.b = null;
    }

    public static PermissionHostFragment S90(FragmentManager r4) {
        PermissionHostFragment r0 = new PermissionHostFragment();
        FragmentTransaction r5 = r4.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "LarkWebView.PermissionHostFragment", 0) == true) goto L6;
        r5 = r5.add(r0, "LarkWebView.PermissionHostFragment");
    L6:
        r5.commitNowAllowingStateLoss();
        return r0;
    }

    public static PermissionHostFragment T90(FragmentManager r1) {
        if (r1.isDestroyed() == true) goto L14;
        Fragment r2 = r1.findFragmentByTag("LarkWebView.PermissionHostFragment");
        if (r2 == null) goto L12;
        if ((r2 instanceof PermissionHostFragment) == true) goto L12;
        throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
    L12:
        return (PermissionHostFragment) r2;
    L14:
        throw new IllegalStateException("Can't access ViewModels from onDestroy");
    }

    public static PermissionHostFragment U90(FragmentManager r5) {
        PermissionHostFragment r1 = T90(r5);     // Catch: IllegalStateException -> L7 Throwable -> L10
        if (r1 != null) goto L14;
        return S90(r5);
    L14:
        return r1;
    L7:
        e = move-exception;
        j.b("LarkWebView.PermissionHostFragment", "create PermissionHostFragment occur exception " + e.getLocalizedMessage());     // Catch: Throwable -> L10
        return S90(r5);
    L10:
        return null;
    }

    @Override // com.ss.android.lark.officewebview.quality.safe.permission.b
    public void requestPermissions(String[] r2, b.InterfaceC0078b r3) {
        this.d.requestPermissions(this, r2, r3);
    }

    public void startActivityForResult(Intent r3, int r4) {
        if (isAdded() == true) goto L6;
        j.e("LarkWebView.PermissionHostFragment", "fragment not attached to Activity");
        return;
    L6:
        a r0 = this.e;
        if (r0.b != null) goto L9;
        r0.b = null;
    L9:
        r0.a = r4;
        super.startActivityForResult(r3, r4);
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        a r0 = this.e;
        if (r3 != r0.a) goto L8;
        b.a r1 = r0.b;
        if (r1 == null) goto L9;
        r1.a(r3, r4, r5);
        r0.b = null;
        return;
    L9:
        return;
    }

    public final void onRequestPermissionsResult(int r3, String[] r4, int[] r5) {
        super.onRequestPermissionsResult(r3, r4, r5);
        c r0 = this.d;
        if (r3 != 1555) goto L7;
        b.InterfaceC0078b r6 = r0.a;
        if (r6 == null) goto L9;
        r6.a(r4, r5);
        r0.a = null;
        return;
    L9:
        return;
    L7:
        r0.getClass();
    }

    @Override // com.ss.android.lark.officewebview.quality.safe.permission.b
    public void startActivityForResult(Intent r2, int r3, b.a r4) {
        this.e.startActivityForResult(this, r2, r3, r4);
    }
}
