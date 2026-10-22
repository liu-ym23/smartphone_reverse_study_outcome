package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    static class Api26Impl {
        private Api26Impl() {
        }

        static RemoteAction createRemoteAction(Icon r2, CharSequence r3, CharSequence r4, PendingIntent r5) {
            return new RemoteAction(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"), r5);
        }

        static PendingIntent getActionIntent(RemoteAction r0) {
            return r0.getActionIntent();
        }

        static CharSequence getContentDescription(RemoteAction r0) {
            return r0.getContentDescription();
        }

        static Icon getIcon(RemoteAction r0) {
            return r0.getIcon();
        }

        static CharSequence getTitle(RemoteAction r0) {
            return r0.getTitle();
        }

        static boolean isEnabled(RemoteAction r0) {
            return r0.isEnabled();
        }

        static void setEnabled(RemoteAction r0, boolean r1) {
            r0.setEnabled(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setShouldShowIcon(RemoteAction r0, boolean r1) {
            r0.setShouldShowIcon(r1);
        }

        static boolean shouldShowIcon(RemoteAction r0) {
            return r0.shouldShowIcon();
        }
    }

    public RemoteActionCompat() {
    }

    public RemoteActionCompat(RemoteActionCompat r2) {
        Preconditions.checkNotNull(r2);
        this.mIcon = r2.mIcon;
        this.mTitle = r2.mTitle;
        this.mContentDescription = r2.mContentDescription;
        this.mActionIntent = r2.mActionIntent;
        this.mEnabled = r2.mEnabled;
        this.mShouldShowIcon = r2.mShouldShowIcon;
    }

    public RemoteActionCompat(IconCompat r3, CharSequence r4, CharSequence r5, PendingIntent r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        this.mIcon = (IconCompat) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), IconCompat.class, "com.obric.memorydata.plugin");
        this.mTitle = (CharSequence) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r7), CharSequence.class, "com.obric.memorydata.plugin");
        this.mContentDescription = (CharSequence) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r8), CharSequence.class, "com.obric.memorydata.plugin");
        this.mActionIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r6), PendingIntent.class, "com.obric.memorydata.plugin");
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction r5) {
        Preconditions.checkNotNull(r5);
        RemoteActionCompat r0 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r5)), Api26Impl.getTitle(r5), Api26Impl.getContentDescription(r5), Api26Impl.getActionIntent(r5));
        r0.setEnabled(Api26Impl.isEnabled(r5));
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0.setShouldShowIcon(Api28Impl.shouldShowIcon(r5));
    L5:
        return r0;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean r1) {
        this.mEnabled = r1;
    }

    public void setShouldShowIcon(boolean r1) {
        this.mShouldShowIcon = r1;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteAction toRemoteAction() {
        RemoteAction r0 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r0, isEnabled());
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Api28Impl.setShouldShowIcon(r0, shouldShowIcon());
    L5:
        return r0;
    }
}
