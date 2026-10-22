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

        public Helper(@NonNull Context r5) {
            this.mContext = r5;
            this.mInflater = LayoutInflater.from(r5);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater r5 = this.mDropDownInflater;
            if (r5 == null) goto L6;
            return r5;
        L6:
            return this.mInflater;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater r5 = this.mDropDownInflater;
            if (r5 != null) goto L6;
            return null;
        L6:
            return r5.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme r5) {
            if (r5 != null) goto L5;
            this.mDropDownInflater = null;
            return;
        L5:
            if (r5.equals(this.mContext.getTheme()) == false) goto L7;
            this.mDropDownInflater = this.mInflater;
            return;
        L7:
            this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, r5));
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme r5);
}
