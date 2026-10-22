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
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Compatibility {

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static void getValueForDensity(@NonNull Resources r5, int r10, int r11, @NonNull TypedValue r12, boolean r13) {
            r5.getValueForDensity(r10, r11, r12, r13);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void setAutoCancel(@NonNull ObjectAnimator r5, boolean r10) {
            r5.setAutoCancel(r10);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @DoNotInline
        public static Drawable createFromXmlInner(@NonNull Resources r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) throws IOException, XmlPullParserException {
            return Drawable.createFromXmlInner(r5, r10, r11, r12);
        }

        @DoNotInline
        public static int getChangingConfigurations(@NonNull TypedArray r5) {
            return r5.getChangingConfigurations();
        }

        @DoNotInline
        public static void inflate(@NonNull Drawable r5, @NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws IOException, XmlPullParserException {
            r5.inflate(r10, r11, r12, r13);
        }
    }

    private Compatibility() {
    }
}
