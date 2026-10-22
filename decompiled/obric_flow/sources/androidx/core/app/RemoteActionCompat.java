package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static RemoteAction createRemoteAction(Icon r5, CharSequence r10, CharSequence r11, PendingIntent r12) {
            return new RemoteAction(r5, r10, r11, r12);
        }

        @DoNotInline
        public static PendingIntent getActionIntent(RemoteAction r5) {
            return r5.getActionIntent();
        }

        @DoNotInline
        public static CharSequence getContentDescription(RemoteAction r5) {
            return r5.getContentDescription();
        }

        @DoNotInline
        public static Icon getIcon(RemoteAction r5) {
            return r5.getIcon();
        }

        @DoNotInline
        public static CharSequence getTitle(RemoteAction r5) {
            return r5.getTitle();
        }

        @DoNotInline
        public static boolean isEnabled(RemoteAction r5) {
            return r5.isEnabled();
        }

        @DoNotInline
        public static void setEnabled(RemoteAction r5, boolean r10) {
            r5.setEnabled(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void setShouldShowIcon(RemoteAction r5, boolean r10) {
            r5.setShouldShowIcon(r10);
        }

        @DoNotInline
        public static boolean shouldShowIcon(RemoteAction r5) {
            return r5.shouldShowIcon();
        }
    }

    public RemoteActionCompat(@NonNull IconCompat r5, @NonNull CharSequence r10, @NonNull CharSequence r11, @NonNull PendingIntent r12) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r5);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r10);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r11);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r12);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction r5) {
        Preconditions.checkNotNull(r5);
        RemoteActionCompat r10 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r5)), Api26Impl.getTitle(r5), Api26Impl.getContentDescription(r5), Api26Impl.getActionIntent(r5));
        r10.setEnabled(Api26Impl.isEnabled(r5));
        r10.setShouldShowIcon(Api28Impl.shouldShowIcon(r5));
        return r10;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @NonNull
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @NonNull
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean r5) {
        this.mEnabled = r5;
    }

    public void setShouldShowIcon(boolean r5) {
        this.mShouldShowIcon = r5;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        RemoteAction r5 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r5, isEnabled());
        Api28Impl.setShouldShowIcon(r5, shouldShowIcon());
        return r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat r5) {
        Preconditions.checkNotNull(r5);
        this.mIcon = r5.mIcon;
        this.mTitle = r5.mTitle;
        this.mContentDescription = r5.mContentDescription;
        this.mActionIntent = r5.mActionIntent;
        this.mEnabled = r5.mEnabled;
        this.mShouldShowIcon = r5.mShouldShowIcon;
    }
}
