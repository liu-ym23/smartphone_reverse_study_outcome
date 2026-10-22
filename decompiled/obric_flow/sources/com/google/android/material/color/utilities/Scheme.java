package com.google.android.material.color.utilities;

import ai.j0;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
    }

    public static Scheme dark(int r5) {
        return darkFromCorePalette(CorePalette.of(r5));
    }

    public static Scheme darkContent(int r5) {
        return darkFromCorePalette(CorePalette.contentOf(r5));
    }

    private static Scheme darkFromCorePalette(CorePalette r10) {
        return new Scheme().withPrimary(r10.f8525a1.tone(80)).withOnPrimary(r10.f8525a1.tone(20)).withPrimaryContainer(r10.f8525a1.tone(30)).withOnPrimaryContainer(r10.f8525a1.tone(90)).withSecondary(r10.f8526a2.tone(80)).withOnSecondary(r10.f8526a2.tone(20)).withSecondaryContainer(r10.f8526a2.tone(30)).withOnSecondaryContainer(r10.f8526a2.tone(90)).withTertiary(r10.f8527a3.tone(80)).withOnTertiary(r10.f8527a3.tone(20)).withTertiaryContainer(r10.f8527a3.tone(30)).withOnTertiaryContainer(r10.f8527a3.tone(90)).withError(r10.error.tone(80)).withOnError(r10.error.tone(20)).withErrorContainer(r10.error.tone(30)).withOnErrorContainer(r10.error.tone(80)).withBackground(r10.f8528n1.tone(10)).withOnBackground(r10.f8528n1.tone(90)).withSurface(r10.f8528n1.tone(10)).withOnSurface(r10.f8528n1.tone(90)).withSurfaceVariant(r10.f8529n2.tone(30)).withOnSurfaceVariant(r10.f8529n2.tone(80)).withOutline(r10.f8529n2.tone(60)).withOutlineVariant(r10.f8529n2.tone(30)).withShadow(r10.f8528n1.tone(0)).withScrim(r10.f8528n1.tone(0)).withInverseSurface(r10.f8528n1.tone(90)).withInverseOnSurface(r10.f8528n1.tone(20)).withInversePrimary(r10.f8525a1.tone(40));
    }

    public static Scheme light(int r5) {
        return lightFromCorePalette(CorePalette.of(r5));
    }

    public static Scheme lightContent(int r5) {
        return lightFromCorePalette(CorePalette.contentOf(r5));
    }

    private static Scheme lightFromCorePalette(CorePalette r10) {
        return new Scheme().withPrimary(r10.f8525a1.tone(40)).withOnPrimary(r10.f8525a1.tone(100)).withPrimaryContainer(r10.f8525a1.tone(90)).withOnPrimaryContainer(r10.f8525a1.tone(10)).withSecondary(r10.f8526a2.tone(40)).withOnSecondary(r10.f8526a2.tone(100)).withSecondaryContainer(r10.f8526a2.tone(90)).withOnSecondaryContainer(r10.f8526a2.tone(10)).withTertiary(r10.f8527a3.tone(40)).withOnTertiary(r10.f8527a3.tone(100)).withTertiaryContainer(r10.f8527a3.tone(90)).withOnTertiaryContainer(r10.f8527a3.tone(10)).withError(r10.error.tone(40)).withOnError(r10.error.tone(100)).withErrorContainer(r10.error.tone(90)).withOnErrorContainer(r10.error.tone(10)).withBackground(r10.f8528n1.tone(99)).withOnBackground(r10.f8528n1.tone(10)).withSurface(r10.f8528n1.tone(99)).withOnSurface(r10.f8528n1.tone(10)).withSurfaceVariant(r10.f8529n2.tone(90)).withOnSurfaceVariant(r10.f8529n2.tone(30)).withOutline(r10.f8529n2.tone(50)).withOutlineVariant(r10.f8529n2.tone(80)).withShadow(r10.f8528n1.tone(0)).withScrim(r10.f8528n1.tone(0)).withInverseSurface(r10.f8528n1.tone(20)).withInverseOnSurface(r10.f8528n1.tone(95)).withInversePrimary(r10.f8525a1.tone(80));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Scheme) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        Scheme r10 = (Scheme) r5;
        if (this.primary == r10.primary) goto L15;
        return false;
    L15:
        if (this.onPrimary == r10.onPrimary) goto L18;
        return false;
    L18:
        if (this.primaryContainer == r10.primaryContainer) goto L21;
        return false;
    L21:
        if (this.onPrimaryContainer == r10.onPrimaryContainer) goto L24;
        return false;
    L24:
        if (this.secondary == r10.secondary) goto L27;
        return false;
    L27:
        if (this.onSecondary == r10.onSecondary) goto L30;
        return false;
    L30:
        if (this.secondaryContainer == r10.secondaryContainer) goto L33;
        return false;
    L33:
        if (this.onSecondaryContainer == r10.onSecondaryContainer) goto L36;
        return false;
    L36:
        if (this.tertiary == r10.tertiary) goto L39;
        return false;
    L39:
        if (this.onTertiary == r10.onTertiary) goto L42;
        return false;
    L42:
        if (this.tertiaryContainer == r10.tertiaryContainer) goto L45;
        return false;
    L45:
        if (this.onTertiaryContainer == r10.onTertiaryContainer) goto L48;
        return false;
    L48:
        if (this.error == r10.error) goto L51;
        return false;
    L51:
        if (this.onError == r10.onError) goto L54;
        return false;
    L54:
        if (this.errorContainer == r10.errorContainer) goto L57;
        return false;
    L57:
        if (this.onErrorContainer == r10.onErrorContainer) goto L60;
        return false;
    L60:
        if (this.background == r10.background) goto L63;
        return false;
    L63:
        if (this.onBackground == r10.onBackground) goto L66;
        return false;
    L66:
        if (this.surface == r10.surface) goto L69;
        return false;
    L69:
        if (this.onSurface == r10.onSurface) goto L72;
        return false;
    L72:
        if (this.surfaceVariant == r10.surfaceVariant) goto L75;
        return false;
    L75:
        if (this.onSurfaceVariant == r10.onSurfaceVariant) goto L78;
        return false;
    L78:
        if (this.outline == r10.outline) goto L81;
        return false;
    L81:
        if (this.outlineVariant == r10.outlineVariant) goto L84;
        return false;
    L84:
        if (this.shadow == r10.shadow) goto L87;
        return false;
    L87:
        if (this.scrim == r10.scrim) goto L90;
        return false;
    L90:
        if (this.inverseSurface == r10.inverseSurface) goto L93;
        return false;
    L93:
        if (this.inverseOnSurface == r10.inverseOnSurface) goto L96;
        return false;
    L96:
        if (this.inversePrimary == r10.inversePrimary) goto L98;
        return false;
    L98:
        return true;
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }

    public void setBackground(int r5) {
        this.background = r5;
    }

    public void setError(int r5) {
        this.error = r5;
    }

    public void setErrorContainer(int r5) {
        this.errorContainer = r5;
    }

    public void setInverseOnSurface(int r5) {
        this.inverseOnSurface = r5;
    }

    public void setInversePrimary(int r5) {
        this.inversePrimary = r5;
    }

    public void setInverseSurface(int r5) {
        this.inverseSurface = r5;
    }

    public void setOnBackground(int r5) {
        this.onBackground = r5;
    }

    public void setOnError(int r5) {
        this.onError = r5;
    }

    public void setOnErrorContainer(int r5) {
        this.onErrorContainer = r5;
    }

    public void setOnPrimary(int r5) {
        this.onPrimary = r5;
    }

    public void setOnPrimaryContainer(int r5) {
        this.onPrimaryContainer = r5;
    }

    public void setOnSecondary(int r5) {
        this.onSecondary = r5;
    }

    public void setOnSecondaryContainer(int r5) {
        this.onSecondaryContainer = r5;
    }

    public void setOnSurface(int r5) {
        this.onSurface = r5;
    }

    public void setOnSurfaceVariant(int r5) {
        this.onSurfaceVariant = r5;
    }

    public void setOnTertiary(int r5) {
        this.onTertiary = r5;
    }

    public void setOnTertiaryContainer(int r5) {
        this.onTertiaryContainer = r5;
    }

    public void setOutline(int r5) {
        this.outline = r5;
    }

    public void setOutlineVariant(int r5) {
        this.outlineVariant = r5;
    }

    public void setPrimary(int r5) {
        this.primary = r5;
    }

    public void setPrimaryContainer(int r5) {
        this.primaryContainer = r5;
    }

    public void setScrim(int r5) {
        this.scrim = r5;
    }

    public void setSecondary(int r5) {
        this.secondary = r5;
    }

    public void setSecondaryContainer(int r5) {
        this.secondaryContainer = r5;
    }

    public void setShadow(int r5) {
        this.shadow = r5;
    }

    public void setSurface(int r5) {
        this.surface = r5;
    }

    public void setSurfaceVariant(int r5) {
        this.surfaceVariant = r5;
    }

    public void setTertiary(int r5) {
        this.tertiary = r5;
    }

    public void setTertiaryContainer(int r5) {
        this.tertiaryContainer = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Scheme{primary=");
        r5.append(this.primary);
        r5.append(", onPrimary=");
        r5.append(this.onPrimary);
        r5.append(", primaryContainer=");
        r5.append(this.primaryContainer);
        r5.append(", onPrimaryContainer=");
        r5.append(this.onPrimaryContainer);
        r5.append(", secondary=");
        r5.append(this.secondary);
        r5.append(", onSecondary=");
        r5.append(this.onSecondary);
        r5.append(", secondaryContainer=");
        r5.append(this.secondaryContainer);
        r5.append(", onSecondaryContainer=");
        r5.append(this.onSecondaryContainer);
        r5.append(", tertiary=");
        r5.append(this.tertiary);
        r5.append(", onTertiary=");
        r5.append(this.onTertiary);
        r5.append(", tertiaryContainer=");
        r5.append(this.tertiaryContainer);
        r5.append(", onTertiaryContainer=");
        r5.append(this.onTertiaryContainer);
        r5.append(", error=");
        r5.append(this.error);
        r5.append(", onError=");
        r5.append(this.onError);
        r5.append(", errorContainer=");
        r5.append(this.errorContainer);
        r5.append(", onErrorContainer=");
        r5.append(this.onErrorContainer);
        r5.append(", background=");
        r5.append(this.background);
        r5.append(", onBackground=");
        r5.append(this.onBackground);
        r5.append(", surface=");
        r5.append(this.surface);
        r5.append(", onSurface=");
        r5.append(this.onSurface);
        r5.append(", surfaceVariant=");
        r5.append(this.surfaceVariant);
        r5.append(", onSurfaceVariant=");
        r5.append(this.onSurfaceVariant);
        r5.append(", outline=");
        r5.append(this.outline);
        r5.append(", outlineVariant=");
        r5.append(this.outlineVariant);
        r5.append(", shadow=");
        r5.append(this.shadow);
        r5.append(", scrim=");
        r5.append(this.scrim);
        r5.append(", inverseSurface=");
        r5.append(this.inverseSurface);
        r5.append(", inverseOnSurface=");
        r5.append(this.inverseOnSurface);
        r5.append(", inversePrimary=");
        return j0.n(r5, this.inversePrimary, '}');
    }

    public Scheme withBackground(int r5) {
        this.background = r5;
        return this;
    }

    public Scheme withError(int r5) {
        this.error = r5;
        return this;
    }

    public Scheme withErrorContainer(int r5) {
        this.errorContainer = r5;
        return this;
    }

    public Scheme withInverseOnSurface(int r5) {
        this.inverseOnSurface = r5;
        return this;
    }

    public Scheme withInversePrimary(int r5) {
        this.inversePrimary = r5;
        return this;
    }

    public Scheme withInverseSurface(int r5) {
        this.inverseSurface = r5;
        return this;
    }

    public Scheme withOnBackground(int r5) {
        this.onBackground = r5;
        return this;
    }

    public Scheme withOnError(int r5) {
        this.onError = r5;
        return this;
    }

    public Scheme withOnErrorContainer(int r5) {
        this.onErrorContainer = r5;
        return this;
    }

    public Scheme withOnPrimary(int r5) {
        this.onPrimary = r5;
        return this;
    }

    public Scheme withOnPrimaryContainer(int r5) {
        this.onPrimaryContainer = r5;
        return this;
    }

    public Scheme withOnSecondary(int r5) {
        this.onSecondary = r5;
        return this;
    }

    public Scheme withOnSecondaryContainer(int r5) {
        this.onSecondaryContainer = r5;
        return this;
    }

    public Scheme withOnSurface(int r5) {
        this.onSurface = r5;
        return this;
    }

    public Scheme withOnSurfaceVariant(int r5) {
        this.onSurfaceVariant = r5;
        return this;
    }

    public Scheme withOnTertiary(int r5) {
        this.onTertiary = r5;
        return this;
    }

    public Scheme withOnTertiaryContainer(int r5) {
        this.onTertiaryContainer = r5;
        return this;
    }

    public Scheme withOutline(int r5) {
        this.outline = r5;
        return this;
    }

    public Scheme withOutlineVariant(int r5) {
        this.outlineVariant = r5;
        return this;
    }

    public Scheme withPrimary(int r5) {
        this.primary = r5;
        return this;
    }

    public Scheme withPrimaryContainer(int r5) {
        this.primaryContainer = r5;
        return this;
    }

    public Scheme withScrim(int r5) {
        this.scrim = r5;
        return this;
    }

    public Scheme withSecondary(int r5) {
        this.secondary = r5;
        return this;
    }

    public Scheme withSecondaryContainer(int r5) {
        this.secondaryContainer = r5;
        return this;
    }

    public Scheme withShadow(int r5) {
        this.shadow = r5;
        return this;
    }

    public Scheme withSurface(int r5) {
        this.surface = r5;
        return this;
    }

    public Scheme withSurfaceVariant(int r5) {
        this.surfaceVariant = r5;
        return this;
    }

    public Scheme withTertiary(int r5) {
        this.tertiary = r5;
        return this;
    }

    public Scheme withTertiaryContainer(int r5) {
        this.tertiaryContainer = r5;
        return this;
    }

    public Scheme(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r114, int r115, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31) {
        this.primary = r5;
        this.onPrimary = r10;
        this.primaryContainer = r11;
        this.onPrimaryContainer = r12;
        this.secondary = r13;
        this.onSecondary = r14;
        this.secondaryContainer = r15;
        this.onSecondaryContainer = r16;
        this.tertiary = r17;
        this.onTertiary = r18;
        this.tertiaryContainer = r19;
        this.onTertiaryContainer = r110;
        this.error = r111;
        this.onError = r112;
        this.errorContainer = r113;
        this.onErrorContainer = r114;
        this.background = r115;
        this.onBackground = r20;
        this.surface = r21;
        this.onSurface = r22;
        this.surfaceVariant = r23;
        this.onSurfaceVariant = r24;
        this.outline = r25;
        this.outlineVariant = r26;
        this.shadow = r27;
        this.scrim = r28;
        this.inverseSurface = r29;
        this.inverseOnSurface = r30;
        this.inversePrimary = r31;
    }
}
