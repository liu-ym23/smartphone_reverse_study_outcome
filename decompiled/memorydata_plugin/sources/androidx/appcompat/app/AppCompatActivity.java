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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements ActionBarDrawerToggle.DelegateProvider, AppCompatCallback, TaskStackBuilder.SupportParentable {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        initDelegate();
    }

    public AppCompatActivity(int r1) {
        super(r1);
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

    private boolean performMenuItemShortcut(KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return false;
    L5:
        if (r3.isCtrlPressed() == false) goto L7;
        return false;
    L7:
        if (KeyEvent.metaStateHasNoModifiers(r3.getMetaState()) == false) goto L9;
        return false;
    L9:
        if (r3.getRepeatCount() == 0) goto L11;
        return false;
    L11:
        if (KeyEvent.isModifierKey(r3.getKeyCode()) == true) goto L25;
        Window r2 = getWindow();
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.getDecorView() != null) goto L17;
        return false;
    L17:
        if (r2.getDecorView().dispatchKeyShortcutEvent(r3) == false) goto L28;
        return true;
    L28:
        return false;
    L25:
        return false;
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        getDelegate().addContentView(r1, r2);
    }

    public void attachBaseContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super.attachBaseContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDelegate().attachBaseContext2(r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public void closeOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r0.closeOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean dispatchKeyEvent(KeyEvent r4) {
        int r0 = r4.getKeyCode();
        ActionBar r1 = getSupportActionBar();
        if (r0 != 82) goto L10;
        if (r1 == null) goto L10;
        if (r1.onMenuKeyEvent(r4) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r4);
    }

    public <T extends View> T findViewById(int r1) {
        return (T) getDelegate().findViewById(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resources getResources() {
        if (this.mResources == null) goto L5;
    L7:
        Resources r0 = this.mResources;
        if (r0 == null) goto L10;
        return r0;
    L10:
        return super.getResources();
    L5:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L7;
        this.mResources = new VectorEnabledTintResources(this, super.getResources());
        goto L7
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        getDelegate().onConfigurationChanged(r2);
        if (this.mResources == null) goto L6;
        Configuration r3 = super.getResources().getConfiguration();
        DisplayMetrics r0 = super.getResources().getDisplayMetrics();
        this.mResources.updateConfiguration(r3, r0);
        return;
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder r1) {
        r1.addParentStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (performMenuItemShortcut(r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    public void onLocalesChanged(LocaleListCompat r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public final boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L6;
        return true;
    L6:
        ActionBar r6 = getSupportActionBar();
        if (r5.getItemId() != 16908332) goto L13;
        if (r6 != null) goto L10;
        return false;
    L10:
        if ((r6.getDisplayOptions() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    public boolean onMenuOpened(int r3, Menu r4) {
        return super.onMenuOpened(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin"));
    }

    public void onNightModeChanged(int r1) {
    }

    @Override // androidx.activity.ComponentActivity
    public void onPanelClosed(int r3, Menu r4) {
        super.onPanelClosed(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin"));
    }

    public void onPostCreate(Bundle r1) {
        super.onPostCreate(r1);
        getDelegate().onPostCreate(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r1) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onSupportNavigateUp() {
        Intent r0 = getSupportParentActivityIntent();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r0) == false) goto L10;
        TaskStackBuilder r1 = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(r1);
        onPrepareSupportNavigateUpTaskStack(r1);
        r1.startActivities();
        ActivityCompat.finishAffinity(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r0);
        return true;
    }

    public void onTitleChanged(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        super.onTitleChanged(r5, r4);
        getDelegate().setTitle(r5);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r2) {
        ActionMode.Callback r1 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r2, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        return null;
    }

    public void openOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r0.openOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(int r1) {
        initViewTreeOwners();
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View r1) {
        initViewTreeOwners();
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        getDelegate().setContentView(r1, r2);
    }

    public void setSupportActionBar(Toolbar r1) {
        getDelegate().setSupportActionBar(r1);
    }

    @Deprecated
    public void setSupportProgress(int r1) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean r1) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean r1) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean r1) {
    }

    public void setTheme(int r1) {
        super.setTheme(r1);
        getDelegate().setTheme(r1);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        return getDelegate().startSupportActionMode(r4);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportNavigateUpTo(Intent r1) {
        NavUtils.navigateUpTo(this, r1);
    }

    public boolean supportRequestWindowFeature(int r1) {
        return getDelegate().requestWindowFeature(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean supportShouldUpRecreateTask(Intent r1) {
        return NavUtils.shouldUpRecreateTask(this, r1);
    }
}
