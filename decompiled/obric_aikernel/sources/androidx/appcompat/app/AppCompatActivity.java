package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        initDelegate();
    }

    @ContentView
    public AppCompatActivity(@LayoutRes int r10) {
        super(r10);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new AnonymousClass1(this));
        addOnContextAvailableListener(new AnonymousClass2(this));
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent r10) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return false;
    L5:
        if (r10.isCtrlPressed() == false) goto L7;
        return false;
    L7:
        if (KeyEvent.metaStateHasNoModifiers(r10.getMetaState()) == false) goto L9;
        return false;
    L9:
        if (r10.getRepeatCount() == 0) goto L11;
        return false;
    L11:
        if (KeyEvent.isModifierKey(r10.getKeyCode()) == true) goto L25;
        Window r11 = getWindow();
        if (r11 != null) goto L15;
        return false;
    L15:
        if (r11.getDecorView() != null) goto L17;
        return false;
    L17:
        if (r11.getDecorView().dispatchKeyShortcutEvent(r10) == false) goto L28;
        return true;
    L28:
        return false;
    L25:
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r10, ViewGroup.LayoutParams r11) {
        initViewTreeOwners();
        getDelegate().addContentView(r10, r11);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context r10) {
        super.attachBaseContext(getDelegate().attachBaseContext2(r10));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar r10 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r10 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r10.closeOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        int r11 = r10.getKeyCode();
        ActionBar r12 = getSupportActionBar();
        if (r11 != 82) goto L10;
        if (r12 == null) goto L10;
        if (r12.onMenuKeyEvent(r10) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r10);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(@IdRes int r10) {
        return (T) getDelegate().findViewById(r10);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    @Nullable
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null) goto L5;
    L7:
        Resources r10 = this.mResources;
        if (r10 == null) goto L10;
        return r10;
    L10:
        return super.getResources();
    L5:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L7;
        this.mResources = new VectorEnabledTintResources(this, super.getResources());
        goto L7
    }

    @Nullable
    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    @Nullable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration r10) {
        super.onConfigurationChanged(r10);
        getDelegate().onConfigurationChanged(r10);
        if (this.mResources == null) goto L6;
        Configuration r11 = super.getResources().getConfiguration();
        DisplayMetrics r12 = super.getResources().getDisplayMetrics();
        this.mResources.updateConfiguration(r11, r12);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder r10) {
        r10.addParentStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (performMenuItemShortcut(r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r10, r11);
    }

    protected void onLocalesChanged(@NonNull LocaleListCompat r10) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L6;
        return true;
    L6:
        ActionBar r12 = getSupportActionBar();
        if (r11.getItemId() != 16908332) goto L13;
        if (r12 != null) goto L10;
        return false;
    L10:
        if ((r12.getDisplayOptions() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r10, Menu r11) {
        return super.onMenuOpened(r10, r11);
    }

    protected void onNightModeChanged(int r10) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r10, @NonNull Menu r11) {
        super.onPanelClosed(r10, r11);
    }

    @Override // android.app.Activity
    protected void onPostCreate(@Nullable Bundle r10) {
        super.onPostCreate(r10);
        getDelegate().onPostCreate(r10);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder r10) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @CallSuper
    public void onSupportActionModeFinished(@NonNull ActionMode r10) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @CallSuper
    public void onSupportActionModeStarted(@NonNull ActionMode r10) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent r10 = getSupportParentActivityIntent();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r10) == false) goto L10;
        TaskStackBuilder r11 = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(r11);
        onPrepareSupportNavigateUpTaskStack(r11);
        r11.startActivities();
        ActivityCompat.finishAffinity(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r10);
        return true;
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence r10, int r11) {
        super.onTitleChanged(r10, r11);
        getDelegate().setTitle(r10);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @Nullable
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback r10) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar r10 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r10 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r10.openOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@LayoutRes int r10) {
        initViewTreeOwners();
        getDelegate().setContentView(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r10) {
        initViewTreeOwners();
        getDelegate().setContentView(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        initViewTreeOwners();
        getDelegate().setContentView(r10, r11);
    }

    public void setSupportActionBar(@Nullable Toolbar r10) {
        getDelegate().setSupportActionBar(r10);
    }

    @Deprecated
    public void setSupportProgress(int r10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean r10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean r10) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean r10) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@StyleRes int r10) {
        super.setTheme(r10);
        getDelegate().setTheme(r10);
    }

    @Nullable
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback r10) {
        return getDelegate().startSupportActionMode(r10);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(@NonNull Intent r10) {
        NavUtils.navigateUpTo(this, r10);
    }

    public boolean supportRequestWindowFeature(int r10) {
        return getDelegate().requestWindowFeature(r10);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent r10) {
        return NavUtils.shouldUpRecreateTask(this, r10);
    }
}
