package androidx.core.view;

import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void setClassName(ViewStructure r5, String r10) {
            r5.setClassName(r10);
        }

        @DoNotInline
        public static void setContentDescription(ViewStructure r5, CharSequence r10) {
            r5.setContentDescription(r10);
        }

        @DoNotInline
        public static void setDimens(ViewStructure r5, int r10, int r11, int r12, int r13, int r14, int r15) {
            r5.setDimens(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static void setText(ViewStructure r5, CharSequence r10) {
            r5.setText(r10);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure r5) {
        this.mWrappedObj = r5;
    }

    @NonNull
    @RequiresApi(23)
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure r5) {
        return new ViewStructureCompat(r5);
    }

    public void setClassName(@NonNull String r5) {
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, r5);
    }

    public void setContentDescription(@NonNull CharSequence r5) {
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, r5);
    }

    public void setDimens(int r10, int r11, int r12, int r13, int r14, int r15) {
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, r10, r11, r12, r13, r14, r15);
    }

    public void setText(@NonNull CharSequence r5) {
        Api23Impl.setText((ViewStructure) this.mWrappedObj, r5);
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
