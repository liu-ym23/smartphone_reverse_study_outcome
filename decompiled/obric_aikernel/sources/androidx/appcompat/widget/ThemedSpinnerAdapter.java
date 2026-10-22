package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public Helper(@NonNull Context r10) {
            this.mContext = r10;
            this.mInflater = LayoutInflater.from(r10);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater r10 = this.mDropDownInflater;
            if (r10 == null) goto L6;
            return r10;
        L6:
            return this.mInflater;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater r10 = this.mDropDownInflater;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme r10) {
            if (r10 != null) goto L6;
            LayoutInflater r11 = null;
        L4:
            this.mDropDownInflater = r11;
            return;
        L6:
            if (r10.equals(this.mContext.getTheme()) == false) goto L8;
            r11 = this.mInflater;
            goto L4
        L8:
            r11 = LayoutInflater.from(new ContextThemeWrapper(this.mContext, r10));
            goto L4
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme r10);
}
