package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Compatibility {

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static void getValueForDensity(@NonNull Resources r10, int r11, int r12, @NonNull TypedValue r13, boolean r14) {
            r10.getValueForDensity(r11, r12, r13, r14);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void setAutoCancel(@NonNull ObjectAnimator r10, boolean r11) {
            r10.setAutoCancel(r11);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @DoNotInline
        public static Drawable createFromXmlInner(@NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
            return Drawable.createFromXmlInner(r10, r11, r12, r13);
        }

        @DoNotInline
        public static int getChangingConfigurations(@NonNull TypedArray r10) {
            return r10.getChangingConfigurations();
        }

        @DoNotInline
        public static void inflate(@NonNull Drawable r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
            r10.inflate(r11, r12, r13, r14);
        }
    }

    private Compatibility() {
    }
}
