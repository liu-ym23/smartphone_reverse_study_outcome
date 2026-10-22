package b0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b0.a$a, reason: collision with other inner class name */
    public static class C0028a {
        public static int a(Drawable r8) {
            return r8.getAlpha();
        }

        public static Drawable b(DrawableContainer.DrawableContainerState r8, int r10) {
            return r8.getChild(r10);
        }

        public static Drawable c(InsetDrawable r8) {
            return r8.getDrawable();
        }

        public static boolean d(Drawable r8) {
            return r8.isAutoMirrored();
        }

        public static void e(Drawable r8, boolean r10) {
            r8.setAutoMirrored(r10);
        }
    }

    public static class b {
        public static void a(Drawable r8, Resources.Theme r10) {
            r8.applyTheme(r10);
        }

        public static boolean b(Drawable r8) {
            return r8.canApplyTheme();
        }

        public static ColorFilter c(Drawable r8) {
            return r8.getColorFilter();
        }

        public static void d(Drawable r8, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
            r8.inflate(r10, r11, r12, r13);
        }

        public static void e(Drawable r8, float r10, float r11) {
            r8.setHotspot(r10, r11);
        }

        public static void f(Drawable r8, int r10, int r11, int r12, int r13) {
            r8.setHotspotBounds(r10, r11, r12, r13);
        }

        public static void g(Drawable r8, int r10) {
            r8.setTint(r10);
        }

        public static void h(Drawable r8, ColorStateList r10) {
            r8.setTintList(r10);
        }

        public static void i(Drawable r8, PorterDuff.Mode r10) {
            r8.setTintMode(r10);
        }
    }

    public static class c {
        public static int a(Drawable r8) {
            return r8.getLayoutDirection();
        }

        public static boolean b(Drawable r8, int r10) {
            return r8.setLayoutDirection(r10);
        }
    }

    public static void a(Drawable r8, int r10) {
        b.g(r8, r10);
    }

    public static void b(Drawable r8, ColorStateList r10) {
        b.h(r8, r10);
    }

    public static void c(Drawable r8, PorterDuff.Mode r10) {
        b.i(r8, r10);
    }
}
