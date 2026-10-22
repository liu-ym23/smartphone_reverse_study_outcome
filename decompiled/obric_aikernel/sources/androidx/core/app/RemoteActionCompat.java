package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
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
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static RemoteAction createRemoteAction(Icon r10, CharSequence r11, CharSequence r12, PendingIntent r13) {
            return new RemoteAction(r10, r11, r12, r13);
        }

        @DoNotInline
        static PendingIntent getActionIntent(RemoteAction r10) {
            return r10.getActionIntent();
        }

        @DoNotInline
        static CharSequence getContentDescription(RemoteAction r10) {
            return r10.getContentDescription();
        }

        @DoNotInline
        static Icon getIcon(RemoteAction r10) {
            return r10.getIcon();
        }

        @DoNotInline
        static CharSequence getTitle(RemoteAction r10) {
            return r10.getTitle();
        }

        @DoNotInline
        static boolean isEnabled(RemoteAction r10) {
            return r10.isEnabled();
        }

        @DoNotInline
        static void setEnabled(RemoteAction r10, boolean r11) {
            r10.setEnabled(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void setShouldShowIcon(RemoteAction r10, boolean r11) {
            r10.setShouldShowIcon(r11);
        }

        @DoNotInline
        static boolean shouldShowIcon(RemoteAction r10) {
            return r10.shouldShowIcon();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat r10) {
        Preconditions.checkNotNull(r10);
        this.mIcon = r10.mIcon;
        this.mTitle = r10.mTitle;
        this.mContentDescription = r10.mContentDescription;
        this.mActionIntent = r10.mActionIntent;
        this.mEnabled = r10.mEnabled;
        this.mShouldShowIcon = r10.mShouldShowIcon;
    }

    public RemoteActionCompat(@NonNull IconCompat r10, @NonNull CharSequence r11, @NonNull CharSequence r12, @NonNull PendingIntent r13) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r10);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r11);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r12);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r13);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction r10) {
        Preconditions.checkNotNull(r10);
        RemoteActionCompat r11 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r10)), Api26Impl.getTitle(r10), Api26Impl.getContentDescription(r10), Api26Impl.getActionIntent(r10));
        r11.setEnabled(Api26Impl.isEnabled(r10));
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r11.setShouldShowIcon(Api28Impl.shouldShowIcon(r10));
    L5:
        return r11;
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

    public void setEnabled(boolean r10) {
        this.mEnabled = r10;
    }

    public void setShouldShowIcon(boolean r10) {
        this.mShouldShowIcon = r10;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        RemoteAction r10 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r10, isEnabled());
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Api28Impl.setShouldShowIcon(r10, shouldShowIcon());
    L5:
        return r10;
    }
}
