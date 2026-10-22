package c0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public interface b extends MenuItem {
    b a(j0.b r8);

    j0.b b();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char r8, int r10);

    @Override // android.view.MenuItem
    b setContentDescription(CharSequence r8);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList r8);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode r8);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char r8, int r10);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char r8, char r10, int r11, int r12);

    @Override // android.view.MenuItem
    b setTooltipText(CharSequence r8);
}
