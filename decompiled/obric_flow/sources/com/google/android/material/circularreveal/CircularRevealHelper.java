package com.google.android.material.circularreveal;

import ai.j0;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 0;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;

    @Nullable
    private Drawable overlayDrawable;

    @Nullable
    private CircularRevealWidget.RevealInfo revealInfo;

    @NonNull
    private final Paint revealPaint;

    @NonNull
    private final Path revealPath;

    @NonNull
    private final Paint scrimPaint;

    @NonNull
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas r5);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        STRATEGY = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(Delegate r5) {
        this.delegate = r5;
        View r10 = (View) r5;
        this.view = r10;
        r10.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint r11 = new Paint(1);
        this.scrimPaint = r11;
        r11.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas r5, int r10, float r11) {
        this.debugPaint.setColor(r10);
        this.debugPaint.setStrokeWidth(r11);
        CircularRevealWidget.RevealInfo r12 = this.revealInfo;
        r5.drawCircle(r12.centerX, r12.centerY, r12.radius - (r11 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas r5) {
        this.delegate.actualDraw(r5);
        if (shouldDrawScrim() == false) goto L6;
        CircularRevealWidget.RevealInfo r10 = this.revealInfo;
        r5.drawCircle(r10.centerX, r10.centerY, r10.radius, this.scrimPaint);
    L6:
        if (shouldDrawCircularReveal() == false) goto L8;
        drawDebugCircle(r5, ViewCompat.MEASURED_STATE_MASK, 10.0f);
        drawDebugCircle(r5, SupportMenu.CATEGORY_MASK, 5.0f);
    L8:
        drawOverlayDrawable(r5);
    }

    private void drawOverlayDrawable(@NonNull Canvas r5) {
        if (shouldDrawOverlayDrawable() == false) goto L6;
        Rect r10 = this.overlayDrawable.getBounds();
        float r11 = this.revealInfo.centerX - (r10.width() / 2.0f);
        float r12 = this.revealInfo.centerY - (r10.height() / 2.0f);
        r5.translate(r11, r12);
        this.overlayDrawable.draw(r5);
        r5.translate(-r11, -r12);
        return;
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo r10) {
        return MathUtils.distanceToFurthestCorner(r10.centerX, r10.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY != 1) goto L7;
        this.revealPath.rewind();
        CircularRevealWidget.RevealInfo r5 = this.revealInfo;
        if (r5 == null) goto L7;
        this.revealPath.addCircle(r5.centerX, r5.centerY, r5.radius, Path.Direction.CW);
    L7:
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo r5 = this.revealInfo;
        if (r5 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (STRATEGY != 0) goto L17;
        if (r10 == false) goto L13;
        return false;
    L13:
        if (this.hasCircularRevealCache == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return !r10;
    L5:
        if (r5.isInvalid() == true) goto L8;
        r10 = false;
        goto L10
    }

    private boolean shouldDrawOverlayDrawable() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L9:
        return false;
    L5:
        if (this.overlayDrawable == null) goto L9;
        if (this.revealInfo == null) goto L9;
        return true;
    }

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.scrimPaint.getColor()) == 0) goto L7;
        return true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY != 0) goto L15;
        this.buildingCircularRevealCache = true;
        this.hasCircularRevealCache = false;
        this.view.buildDrawingCache();
        Bitmap r5 = this.view.getDrawingCache();
        if (r5 == null) goto L7;
    L11:
        if (r5 == null) goto L13;
        Paint r10 = this.revealPaint;
        Shader.TileMode r11 = Shader.TileMode.CLAMP;
        r10.setShader(new BitmapShader(r5, r11, r11));
    L13:
        this.buildingCircularRevealCache = false;
        this.hasCircularRevealCache = true;
        return;
    L7:
        if (this.view.getWidth() == 0) goto L11;
        if (this.view.getHeight() == 0) goto L11;
        r5 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(r5);
        this.view.draw(r12);
        goto L11
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY != 0) goto L6;
        this.hasCircularRevealCache = false;
        this.view.destroyDrawingCache();
        this.revealPaint.setShader(null);
        this.view.invalidate();
        return;
    }

    public void draw(@NonNull Canvas r10) {
        if (shouldDrawCircularReveal() == false) goto L22;
        int r5 = STRATEGY;
        if (r5 != 0) goto L7;
        CircularRevealWidget.RevealInfo r11 = this.revealInfo;
        r10.drawCircle(r11.centerX, r11.centerY, r11.radius, this.revealPaint);
        if (shouldDrawScrim() == false) goto L25;
        CircularRevealWidget.RevealInfo r12 = this.revealInfo;
        r10.drawCircle(r12.centerX, r12.centerY, r12.radius, this.scrimPaint);
    L25:
        drawOverlayDrawable(r10);
        return;
    L7:
        if (r5 != 1) goto L9;
        int r13 = r10.save();
        r10.clipPath(this.revealPath);
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L18;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
    L18:
        r10.restoreToCount(r13);
        goto L25
    L9:
        if (r5 != 2) goto L14;
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L25;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    L14:
        throw new IllegalStateException(j0.g(r5, "Unsupported strategy "));
    L22:
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L25;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo r5 = this.revealInfo;
        if (r5 != null) goto L6;
        return null;
    L6:
        CircularRevealWidget.RevealInfo r10 = new CircularRevealWidget.RevealInfo(r5);
        if (r10.isInvalid() == false) goto L9;
        r10.radius = getDistanceToFurthestCorner(r10);
    L9:
        return r10;
    }

    public boolean isOpaque() {
        if (this.delegate.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDrawCircularReveal() == true) goto L7;
        return true;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable r5) {
        this.overlayDrawable = r5;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int r5) {
        this.scrimPaint.setColor(r5);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo r5) {
        if (r5 != null) goto L4;
        this.revealInfo = null;
    L11:
        invalidateRevealInfo();
        return;
    L4:
        CircularRevealWidget.RevealInfo r10 = this.revealInfo;
        if (r10 != null) goto L7;
        this.revealInfo = new CircularRevealWidget.RevealInfo(r5);
    L9:
        if (MathUtils.geq(r5.radius, getDistanceToFurthestCorner(r5), 1.0E-4f) == false) goto L11;
        this.revealInfo.radius = Float.MAX_VALUE;
        goto L11
    L7:
        r10.set(r5);
        goto L9
    }
}
