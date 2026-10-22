package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

    private boolean performMenuItemShortcut(KeyEvent r5) {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r5, ViewGroup.LayoutParams r10) {
        initViewTreeOwners();
        getDelegate().addContentView(r5, r10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r5) {
        super.attachBaseContext(getDelegate().attachBaseContext2(r5));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar r5 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r5 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r5.closeOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r5) {
        int r10 = r5.getKeyCode();
        ActionBar r11 = getSupportActionBar();
        if (r10 != 82) goto L10;
        if (r11 == null) goto L10;
        if (r11.onMenuKeyEvent(r5) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(@IdRes int r5) {
        return (T) getDelegate().findViewById(r5);
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
        Resources r5 = this.mResources;
        if (r5 == null) goto L10;
        return r5;
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration r5) {
        super.onConfigurationChanged(r5);
        getDelegate().onConfigurationChanged(r5);
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

    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder r5) {
        r5.addParentStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r10) {
        if (performMenuItemShortcut(r10) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r5, r10);
    }

    public void onLocalesChanged(@NonNull LocaleListCompat r5) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r5, @NonNull MenuItem r10) {
        if (super.onMenuItemSelected(r5, r10) == false) goto L6;
        return true;
    L6:
        ActionBar r11 = getSupportActionBar();
        if (r10.getItemId() != 16908332) goto L13;
        if (r11 != null) goto L10;
        return false;
    L10:
        if ((r11.getDisplayOptions() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r5, Menu r10) {
        return super.onMenuOpened(r5, r10);
    }

    public void onNightModeChanged(int r5) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r5, @NonNull Menu r10) {
        super.onPanelClosed(r5, r10);
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle r5) {
        super.onPostCreate(r5);
        getDelegate().onPostCreate(r5);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder r5) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @CallSuper
    public void onSupportActionModeFinished(@NonNull ActionMode r5) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @CallSuper
    public void onSupportActionModeStarted(@NonNull ActionMode r5) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent r5 = getSupportParentActivityIntent();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r5) == false) goto L10;
        TaskStackBuilder r10 = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(r10);
        onPrepareSupportNavigateUpTaskStack(r10);
        r10.startActivities();
        ActivityCompat.finishAffinity(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r5);
        return true;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r5, int r10) {
        super.onTitleChanged(r5, r10);
        getDelegate().setTitle(r5);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @Nullable
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback r5) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar r5 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r5 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r5.openOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@LayoutRes int r5) {
        initViewTreeOwners();
        getDelegate().setContentView(r5);
    }

    public void setSupportActionBar(@Nullable Toolbar r5) {
        getDelegate().setSupportActionBar(r5);
    }

    @Deprecated
    public void setSupportProgress(int r5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean r5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean r5) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean r5) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@StyleRes int r5) {
        super.setTheme(r5);
        getDelegate().setTheme(r5);
    }

    @Nullable
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback r5) {
        return getDelegate().startSupportActionMode(r5);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(@NonNull Intent r5) {
        NavUtils.navigateUpTo(this, r5);
    }

    public boolean supportRequestWindowFeature(int r5) {
        return getDelegate().requestWindowFeature(r5);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent r5) {
        return NavUtils.shouldUpRecreateTask(this, r5);
    }

    @ContentView
    public AppCompatActivity(@LayoutRes int r5) {
        super(r5);
        initDelegate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r5) {
        initViewTreeOwners();
        getDelegate().setContentView(r5);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r5, ViewGroup.LayoutParams r10) {
        initViewTreeOwners();
        getDelegate().setContentView(r5, r10);
    }
}
