package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class c extends Window {
    @Override // android.view.Window
    public final void addContentView(View r1, ViewGroup.LayoutParams r10) {
    }

    @Override // android.view.Window
    public final void closeAllPanels() {
    }

    @Override // android.view.Window
    public final void closePanel(int r1) {
    }

    @Override // android.view.Window
    public final View getCurrentFocus() {
        return null;
    }

    @Override // android.view.Window
    public final int getNavigationBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public final int getStatusBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public final int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public final void invalidatePanelMenu(int r1) {
    }

    @Override // android.view.Window
    public final boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public final boolean isShortcutKey(int r1, KeyEvent r10) {
        return false;
    }

    @Override // android.view.Window
    public final void onActive() {
    }

    @Override // android.view.Window
    public final void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.view.Window
    public final void openPanel(int r1, KeyEvent r10) {
    }

    @Override // android.view.Window
    public final boolean performContextMenuIdentifierAction(int r1, int r10) {
        return true;
    }

    @Override // android.view.Window
    public final boolean performPanelIdentifierAction(int r1, int r10, int r11) {
        return true;
    }

    @Override // android.view.Window
    public final boolean performPanelShortcut(int r1, int r10, KeyEvent r11, int r12) {
        return true;
    }

    @Override // android.view.Window
    public final void restoreHierarchyState(Bundle r1) {
    }

    @Override // android.view.Window
    public final void setBackgroundDrawable(Drawable r1) {
    }

    @Override // android.view.Window
    public final void setChildDrawable(int r1, Drawable r10) {
    }

    @Override // android.view.Window
    public final void setChildInt(int r1, int r10) {
    }

    @Override // android.view.Window
    public final void setContentView(int r1) {
    }

    @Override // android.view.Window
    public final void setContentView(View r1) {
    }

    @Override // android.view.Window
    public final void setContentView(View r1, ViewGroup.LayoutParams r10) {
    }

    @Override // android.view.Window
    public final void setDecorCaptionShade(int r1) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawable(int r1, Drawable r10) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableAlpha(int r1, int r10) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableResource(int r1, int r10) {
    }

    @Override // android.view.Window
    public final void setFeatureDrawableUri(int r1, Uri r10) {
    }

    @Override // android.view.Window
    public final void setFeatureInt(int r1, int r10) {
    }

    @Override // android.view.Window
    public final void setNavigationBarColor(int r1) {
    }

    @Override // android.view.Window
    public final void setResizingCaptionDrawable(Drawable r1) {
    }

    @Override // android.view.Window
    public final void setStatusBarColor(int r1) {
    }

    @Override // android.view.Window
    public final void setTitle(CharSequence r1) {
    }

    @Override // android.view.Window
    public final void setTitleColor(int r1) {
    }

    @Override // android.view.Window
    public final void setVolumeControlStream(int r1) {
    }

    @Override // android.view.Window
    public final boolean superDispatchGenericMotionEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchKeyEvent(KeyEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchKeyShortcutEvent(KeyEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public final boolean superDispatchTrackballEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public final void takeInputQueue(InputQueue.Callback r1) {
    }

    @Override // android.view.Window
    public final void takeKeyEvents(boolean r1) {
    }

    @Override // android.view.Window
    public final void takeSurface(SurfaceHolder.Callback2 r1) {
    }

    @Override // android.view.Window
    public final void togglePanel(int r1, KeyEvent r10) {
    }

    @Override // android.view.Window
    public final Bundle saveHierarchyState() {
        return new Bundle();
    }

    @Override // android.view.Window
    public final LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public c(Context r1) {
        super(r1);
    }
}
