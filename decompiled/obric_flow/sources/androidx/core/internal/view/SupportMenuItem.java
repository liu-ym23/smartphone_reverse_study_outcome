package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    @Nullable
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    @Nullable
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    @Nullable
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    @Nullable
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Nullable
    ActionProvider getSupportActionProvider();

    @Override // android.view.MenuItem
    @Nullable
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    boolean requiresActionButton();

    boolean requiresOverflow();

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(int r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(@Nullable View r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setAlphabeticShortcut(char r5, int r10);

    @Override // android.view.MenuItem
    @NonNull
    /* bridge */ /* synthetic */ default MenuItem setContentDescription(@Nullable CharSequence r5) {
        return setContentDescription(r5);
    }

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setContentDescription(@Nullable CharSequence r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintList(@Nullable ColorStateList r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintMode(@Nullable PorterDuff.Mode r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setNumericShortcut(char r5, int r10);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShortcut(char r5, char r10, int r11, int r12);

    @Override // android.view.MenuItem
    void setShowAsAction(int r5);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShowAsActionFlags(int r5);

    @NonNull
    SupportMenuItem setSupportActionProvider(@Nullable ActionProvider r5);

    @Override // android.view.MenuItem
    @NonNull
    /* bridge */ /* synthetic */ default MenuItem setTooltipText(@Nullable CharSequence r5) {
        return setTooltipText(r5);
    }

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setTooltipText(@Nullable CharSequence r5);
}
