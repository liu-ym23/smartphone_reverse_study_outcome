package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a1;
import com.obric.cae.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e extends androidx.fragment.app.m implements f, androidx.core.app.s.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private h mDelegate;
    private Resources mResources;

    public class a implements androidx.savedstate.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f644a;

        public a(e r8) {
            this.f644a = r8;
        }

        @Override // androidx.savedstate.a.b
        public final Bundle a() {
            Bundle r8 = new Bundle();
            this.f644a.getDelegate().s();
            return r8;
        }
    }

    public class b implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f645a;

        public b(e r8) {
            this.f645a = r8;
        }

        @Override // a.b
        public final void a(Context r8) {
            e r10 = this.f645a;
            h r11 = r10.getDelegate();
            r11.k();
            r10.getSavedStateRegistry().a(e.DELEGATE_TAG);
            r11.o();
        }
    }

    public e() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().e(DELEGATE_TAG, new a(this));
        addOnContextAvailableListener(new b(this));
    }

    private void initViewTreeOwners() {
        View r8 = getWindow().getDecorView();
        he.i.f(r8, "<this>");
        r8.setTag(R.id.view_tree_lifecycle_owner, this);
        View r10 = getWindow().getDecorView();
        he.i.f(r10, "<this>");
        r10.setTag(R.id.view_tree_view_model_store_owner, this);
        View r11 = getWindow().getDecorView();
        he.i.f(r11, "<this>");
        r11.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View r12 = getWindow().getDecorView();
        he.i.f(r12, "<this>");
        r12.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    private boolean performMenuItemShortcut(KeyEvent r8) {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r8, ViewGroup.LayoutParams r10) {
        initViewTreeOwners();
        getDelegate().c(r8, r10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r8) {
        super.attachBaseContext(getDelegate().d(r8));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a r8 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r8 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r8.a() == false) goto L7;
        return;
    }

    @Override // androidx.core.app.e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r8) {
        int r10 = r8.getKeyCode();
        androidx.appcompat.app.a r11 = getSupportActionBar();
        if (r10 != 82) goto L10;
        if (r11 == null) goto L10;
        if (r11.j(r8) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r8);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int r8) {
        return (T) getDelegate().e(r8);
    }

    public h getDelegate() {
        if (this.mDelegate != null) goto L6;
        s.a r8 = h.f648a;
        this.mDelegate = new AppCompatDelegateImpl(this, null, this, this);
    L6:
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().g();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().i();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources r8 = this.mResources;
        if (r8 != null) goto L5;
        int r10 = a1.f1102a;
    L5:
        if (r8 == null) goto L7;
        return r8;
    L7:
        return super.getResources();
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().j();
    }

    @Override // androidx.core.app.s.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.g.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().l();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        getDelegate().n(r8);
        if (this.mResources == null) goto L6;
        Configuration r10 = super.getResources().getConfiguration();
        DisplayMetrics r11 = super.getResources().getDisplayMetrics();
        this.mResources.updateConfiguration(r10, r11);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.s r8) {
        r8.getClass();
        Intent r10 = getSupportParentActivityIntent();
        if (r10 != null) goto L5;
        r10 = androidx.core.app.g.a(this);
    L5:
        if (r10 == null) goto L25;
        ComponentName r11 = r10.getComponent();
        Context r12 = r8.f1672b;
        if (r11 != null) goto L9;
        r11 = r10.resolveActivity(r12.getPackageManager());
    L9:
        ArrayList<Intent> r13 = r8.f1671a;
        int r14 = r13.size();
    L26:
        String r15 = androidx.core.app.g.b(r12, r11);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r15 != null) goto L13;
        Intent r16 = null;
    L17:
        if (r16 == null) goto L22;
        r13.add(r14, r16);     // Catch: PackageManager.NameNotFoundException -> L20
        r11 = r16.getComponent();     // Catch: PackageManager.NameNotFoundException -> L20
        goto L26
    L22:
        r13.add(r10);
        return;
    L13:
        ComponentName r17 = new ComponentName(r11.getPackageName(), r15);     // Catch: PackageManager.NameNotFoundException -> L20
        if (androidx.core.app.g.b(r12, r17) != null) goto L16;
        r16 = Intent.makeMainActivity(r17);     // Catch: PackageManager.NameNotFoundException -> L20
        goto L17
    L16:
        r16 = new Intent().setComponent(r17);     // Catch: PackageManager.NameNotFoundException -> L20
    L20:
        e = move-exception;
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().p();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r8, KeyEvent r10) {
        if (performMenuItemShortcut(r10) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r8, r10);
    }

    public void onLocalesChanged(f0.e r8) {
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r8, MenuItem r10) {
        if (super.onMenuItemSelected(r8, r10) == false) goto L6;
        return true;
    L6:
        androidx.appcompat.app.a r11 = getSupportActionBar();
        if (r10.getItemId() != 16908332) goto L13;
        if (r11 != null) goto L10;
        return false;
    L10:
        if ((r11.d() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r8, Menu r10) {
        return super.onMenuOpened(r8, r10);
    }

    public void onNightModeChanged(int r8) {
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r8, Menu r10) {
        super.onPanelClosed(r8, r10);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r8) {
        super.onPostCreate(r8);
        getDelegate().q();
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().r();
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.s r8) {
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().t();
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().u();
    }

    @Override // androidx.appcompat.app.f
    public void onSupportActionModeFinished(g.b r8) {
    }

    @Override // androidx.appcompat.app.f
    public void onSupportActionModeStarted(g.b r8) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent r8 = getSupportParentActivityIntent();
        if (r8 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r8) == false) goto L14;
        androidx.core.app.s r10 = new androidx.core.app.s(this);
        onCreateSupportNavigateUpTaskStack(r10);
        onPrepareSupportNavigateUpTaskStack(r10);
        ArrayList<Intent> r11 = r10.f1671a;
        if (r11.isEmpty() == true) goto L13;
        Intent[] r12 = (Intent[]) r11.toArray(new Intent[0]);
        r12[0] = new Intent(r12[0]).addFlags(268484608);
        Object r13 = androidx.core.content.a.f1674a;
        androidx.core.content.a.C0011a.a(r10.f1672b, r12, null);
        int r14 = androidx.core.app.a.f1587c;     // Catch: IllegalStateException -> L11
        androidx.core.app.a.C0010a.a(this);     // Catch: IllegalStateException -> L11
        return true;
    L11:
        finish();
        return true;
    L13:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    L14:
        supportNavigateUpTo(r8);
        return true;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r8, int r10) {
        super.onTitleChanged(r8, r10);
        getDelegate().C(r8);
    }

    @Override // androidx.appcompat.app.f
    public g.b onWindowStartingSupportActionMode(g.b.a r8) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a r8 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r8 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r8.k() == false) goto L7;
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r8) {
        initViewTreeOwners();
        getDelegate().x(r8);
    }

    public void setSupportActionBar(Toolbar r8) {
        getDelegate().A(r8);
    }

    @Deprecated
    public void setSupportProgress(int r8) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean r8) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean r8) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean r8) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r8) {
        super.setTheme(r8);
        getDelegate().B(r8);
    }

    public g.b startSupportActionMode(g.b.a r8) {
        return getDelegate().D(r8);
    }

    @Override // androidx.fragment.app.m
    public void supportInvalidateOptionsMenu() {
        getDelegate().l();
    }

    public void supportNavigateUpTo(Intent r8) {
        androidx.core.app.g.a.b(this, r8);
    }

    public boolean supportRequestWindowFeature(int r8) {
        return getDelegate().w(r8);
    }

    public boolean supportShouldUpRecreateTask(Intent r8) {
        return androidx.core.app.g.a.c(this, r8);
    }

    public e(int r8) {
        super(r8);
        initDelegate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r8) {
        initViewTreeOwners();
        getDelegate().y(r8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r8, ViewGroup.LayoutParams r10) {
        initViewTreeOwners();
        getDelegate().z(r8, r10);
    }
}
