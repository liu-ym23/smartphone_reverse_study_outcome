package androidx.core.app;

import ai.j0;
import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    public static class IntentBuilder {

        @Nullable
        private ArrayList<String> mBccAddresses;

        @Nullable
        private ArrayList<String> mCcAddresses;

        @Nullable
        private CharSequence mChooserTitle;

        @NonNull
        private final Context mContext;

        @NonNull
        private final Intent mIntent;

        @Nullable
        private ArrayList<Uri> mStreams;

        @Nullable
        private ArrayList<String> mToAddresses;

        public IntentBuilder(@NonNull Context r5) {
            this.mContext = (Context) Preconditions.checkNotNull(r5);
            Intent r10 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r10;
            r10.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r5.getPackageName());
            r10.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r5.getPackageName());
            r10.addFlags(524288);
        L4:
            if ((r5 instanceof ContextWrapper) == false) goto L9;
            if ((r5 instanceof Activity) == true) goto L7;
            r5 = ((ContextWrapper) r5).getBaseContext();
            goto L4
        L7:
            Activity r11 = (Activity) r5;
        L10:
            if (r11 == null) goto L15;
            ComponentName r12 = r11.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r12);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r12);
            return;
        L15:
            return;
        L9:
            r11 = null;
            goto L10
        }

        private void combineArrayExtra(String r5, ArrayList<String> r10) {
            String[] r11 = this.mIntent.getStringArrayExtra(r5);
            if (r11 == null) goto L5;
            int r12 = r11.length;
        L6:
            String[] r13 = new String[r10.size() + r12];
            r10.toArray(r13);
            if (r11 == null) goto L9;
            System.arraycopy(r11, 0, r13, r10.size(), r12);
        L9:
            this.mIntent.putExtra(r5, r13);
            return;
        L5:
            r12 = 0;
            goto L6
        }

        @NonNull
        @Deprecated
        public static IntentBuilder from(@NonNull Activity r5) {
            return new IntentBuilder(r5);
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String r5) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r5);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String r5) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r5);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String r5) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r5);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri r5) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r5);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        @NonNull
        public Context getContext() {
            return this.mContext;
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> r5 = this.mToAddresses;
            if (r5 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r5);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r10 = this.mCcAddresses;
            if (r10 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r10);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r11 = this.mBccAddresses;
            if (r11 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r11);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r12 = this.mStreams;
            if (r12 != null) goto L14;
        L16:
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r13 = this.mStreams;
            if (r13 != null) goto L19;
        L21:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            this.mIntent.setClipData(null);
            Intent r14 = this.mIntent;
            r14.setFlags(r14.getFlags() & (-2));
        L23:
            return this.mIntent;
        L19:
            if (r13.isEmpty() == true) goto L21;
            this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
            ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L23
        L14:
            if (r12.size() <= 1) goto L16;
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L23
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence r5) {
            this.mChooserTitle = r5;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] r5) {
            this.mIntent.putExtra("android.intent.extra.BCC", r5);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] r5) {
            this.mIntent.putExtra("android.intent.extra.CC", r5);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] r5) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r5);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String r5) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r5);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r5));
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri r5) {
            this.mStreams = null;
            if (r5 == null) goto L5;
            addStream(r5);
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String r5) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r5);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence r5) {
            this.mIntent.putExtra("android.intent.extra.TEXT", r5);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String r5) {
            this.mIntent.setType(r5);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int r5) {
            return setChooserTitle(this.mContext.getText(r5));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] r5) {
            combineArrayExtra("android.intent.extra.BCC", r5);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] r5) {
            combineArrayExtra("android.intent.extra.CC", r5);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] r5) {
            combineArrayExtra("android.intent.extra.EMAIL", r5);
            return this;
        }

        private void combineArrayExtra(@Nullable String r5, @NonNull String[] r10) {
            Intent r11 = getIntent();
            String[] r12 = r11.getStringArrayExtra(r5);
            if (r12 == null) goto L5;
            int r13 = r12.length;
        L6:
            String[] r14 = new String[r10.length + r13];
            if (r12 == null) goto L9;
            System.arraycopy(r12, 0, r14, 0, r13);
        L9:
            System.arraycopy(r10, 0, r14, r13, r10.length);
            r11.putExtra(r5, r14);
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";

        @Nullable
        private final ComponentName mCallingActivity;

        @Nullable
        private final String mCallingPackage;

        @NonNull
        private final Context mContext;

        @NonNull
        private final Intent mIntent;

        @Nullable
        private ArrayList<Uri> mStreams;

        public IntentReader(@NonNull Activity r5) {
            this((Context) Preconditions.checkNotNull(r5), r5.getIntent());
        }

        @NonNull
        @Deprecated
        public static IntentReader from(@NonNull Activity r5) {
            return new IntentReader(r5);
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity != null) goto L5;
            return null;
        L5:
            PackageManager r5 = this.mContext.getPackageManager();
            return r5.getActivityIcon(this.mCallingActivity);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling activity", e);
            return null;
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r5 = this.mContext.getPackageManager();
            return r5.getApplicationIcon(this.mCallingPackage);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling application", e);
            return null;
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r5 = this.mContext.getPackageManager();
            return r5.getApplicationLabel(r5.getApplicationInfo(this.mCallingPackage, 0));
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve label for calling application", e);
            return null;
        }

        @Nullable
        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String r5 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r5 != null) goto L10;
            CharSequence r10 = getText();
            if ((r10 instanceof Spanned) == true) goto L11;
            if (r10 != null) goto L9;
            return r5;
        L9:
            return Html.escapeHtml(r10);
        L11:
            return Html.toHtml((Spanned) r10);
        L10:
            return r5;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r5 = this.mStreams;
            if (r5 == null) goto L12;
            return r5.size();
        L12:
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        @Nullable
        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String r5 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r5) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r5) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }

        public IntentReader(@NonNull Context r5, @NonNull Intent r10) {
            this.mContext = (Context) Preconditions.checkNotNull(r5);
            this.mIntent = (Intent) Preconditions.checkNotNull(r10);
            this.mCallingPackage = ShareCompat.getCallingPackage(r10);
            this.mCallingActivity = ShareCompat.getCallingActivity(r10);
        }

        @Nullable
        public Uri getStream(int r5) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r10 = this.mStreams;
            if (r10 != null) goto L10;
            if (r5 != 0) goto L15;
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r5);
        L10:
            return r10.get(r5);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }
    }

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(@NonNull MenuItem r5, @NonNull IntentBuilder r10) {
        ActionProvider r11 = r5.getActionProvider();
        if ((r11 instanceof ShareActionProvider) == true) goto L5;
        ShareActionProvider r12 = new ShareActionProvider(r10.getContext());
    L6:
        r12.setShareHistoryFileName(HISTORY_FILENAME_PREFIX.concat(r10.getContext().getClass().getName()));
        r12.setShareIntent(r10.getIntent());
        r5.setActionProvider(r12);
        return;
    L5:
        r12 = (ShareActionProvider) r11;
        goto L6
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity r5) {
        Intent r10 = r5.getIntent();
        ComponentName r11 = r5.getCallingActivity();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return getCallingActivity(r10);
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity r5) {
        Intent r10 = r5.getIntent();
        String r11 = r5.getCallingPackage();
        if (r11 != null) goto L7;
        if (r10 != null) goto L6;
        return r11;
    L6:
        return getCallingPackage(r10);
    L7:
        return r11;
    }

    public static void migrateExtraStreamToClipData(@NonNull Intent r10, @NonNull ArrayList<Uri> r11) {
        ClipData r5 = new ClipData(null, new String[]{r10.getType()}, new ClipData.Item(r10.getCharSequenceExtra("android.intent.extra.TEXT"), r10.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, r11.get(0)));
        int r12 = r11.size();
        int r13 = 1;
    L3:
        if (r13 >= r12) goto L5;
        r5.addItem(new ClipData.Item(r11.get(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        r10.setClipData(r5);
        r10.addFlags(1);
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Intent r5) {
        ComponentName r10 = (ComponentName) r5.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return (ComponentName) r5.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
    }

    @Nullable
    public static String getCallingPackage(@NonNull Intent r5) {
        String r10 = r5.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return r5.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }

    @Deprecated
    public static void configureMenuItem(@NonNull Menu r5, @IdRes int r10, @NonNull IntentBuilder r11) {
        MenuItem r12 = r5.findItem(r10);
        if (r12 == null) goto L7;
        configureMenuItem(r12, r11);
        return;
    L7:
        throw new IllegalArgumentException(j0.h(r10, "Could not find menu item with id ", " in the supplied menu"));
    }
}
