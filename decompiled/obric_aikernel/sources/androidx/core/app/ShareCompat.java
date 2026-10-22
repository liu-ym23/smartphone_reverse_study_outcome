package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static String escapeHtml(CharSequence r10) {
            return Html.escapeHtml(r10);
        }

        @DoNotInline
        static void migrateExtraStreamToClipData(@NonNull Intent r10, @NonNull ArrayList<Uri> r11) {
            ClipData r12 = new ClipData(null, new String[]{r10.getType()}, new ClipData.Item(r10.getCharSequenceExtra("android.intent.extra.TEXT"), r10.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, r11.get(0)));
            int r13 = r11.size();
            int r14 = 1;
        L3:
            if (r14 >= r13) goto L5;
            r12.addItem(new ClipData.Item(r11.get(r14)));
            r14 = r14 + 1;
            goto L3
        L5:
            r10.setClipData(r12);
            r10.addFlags(1);
        }

        @DoNotInline
        static void removeClipData(@NonNull Intent r10) {
            r10.setClipData(null);
            r10.setFlags(r10.getFlags() & (-2));
        }
    }

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

        public IntentBuilder(@NonNull Context r10) {
            this.mContext = (Context) Preconditions.checkNotNull(r10);
            Intent r11 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r11;
            r11.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r10.getPackageName());
            r11.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r10.getPackageName());
            r11.addFlags(524288);
        L4:
            if ((r10 instanceof ContextWrapper) == false) goto L9;
            if ((r10 instanceof Activity) == true) goto L7;
            r10 = ((ContextWrapper) r10).getBaseContext();
            goto L4
        L7:
            Activity r12 = (Activity) r10;
        L10:
            if (r12 == null) goto L15;
            ComponentName r13 = r12.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r13);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r13);
            return;
        L15:
            return;
        L9:
            r12 = null;
            goto L10
        }

        private void combineArrayExtra(String r10, ArrayList<String> r11) {
            String[] r12 = this.mIntent.getStringArrayExtra(r10);
            if (r12 == null) goto L5;
            int r13 = r12.length;
        L6:
            String[] r14 = new String[r11.size() + r13];
            r11.toArray(r14);
            if (r12 == null) goto L9;
            System.arraycopy(r12, 0, r14, r11.size(), r13);
        L9:
            this.mIntent.putExtra(r10, r14);
            return;
        L5:
            r13 = 0;
            goto L6
        }

        private void combineArrayExtra(@Nullable String r10, @NonNull String[] r11) {
            Intent r12 = getIntent();
            String[] r13 = r12.getStringArrayExtra(r10);
            if (r13 == null) goto L5;
            int r14 = r13.length;
        L6:
            String[] r15 = new String[r11.length + r14];
            if (r13 == null) goto L9;
            System.arraycopy(r13, 0, r15, 0, r14);
        L9:
            System.arraycopy(r11, 0, r15, r14, r11.length);
            r12.putExtra(r10, r15);
            return;
        L5:
            r14 = 0;
            goto L6
        }

        @NonNull
        @Deprecated
        public static IntentBuilder from(@NonNull Activity r10) {
            return new IntentBuilder(r10);
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String r10) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r10);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] r10) {
            combineArrayExtra("android.intent.extra.BCC", r10);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String r10) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r10);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] r10) {
            combineArrayExtra("android.intent.extra.CC", r10);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String r10) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r10);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] r10) {
            combineArrayExtra("android.intent.extra.EMAIL", r10);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri r10) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r10);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        @NonNull
        Context getContext() {
            return this.mContext;
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> r10 = this.mToAddresses;
            if (r10 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r10);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r11 = this.mCcAddresses;
            if (r11 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r11);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r12 = this.mBccAddresses;
            if (r12 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r12);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r13 = this.mStreams;
            boolean r14 = true;
            if (r13 != null) goto L14;
        L16:
            r14 = false;
        L18:
            if (r14 == true) goto L29;
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r15 = this.mStreams;
            if (r15 != null) goto L22;
        L26:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            if (Build.VERSION.SDK_INT < 16) goto L33;
            Api16Impl.removeClipData(this.mIntent);
        L33:
            return this.mIntent;
        L22:
            if (r15.isEmpty() == true) goto L26;
            this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
            if (Build.VERSION.SDK_INT < 16) goto L33;
        L31:
            Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L33
        L29:
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            if (Build.VERSION.SDK_INT < 16) goto L33;
        L14:
            if (r13.size() <= 1) goto L16;
            goto L16
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int r10) {
            return setChooserTitle(this.mContext.getText(r10));
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence r10) {
            this.mChooserTitle = r10;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] r10) {
            this.mIntent.putExtra("android.intent.extra.BCC", r10);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] r10) {
            this.mIntent.putExtra("android.intent.extra.CC", r10);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] r10) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r10);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String r10) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r10);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r10));
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri r10) {
            this.mStreams = null;
            if (r10 == null) goto L5;
            addStream(r10);
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String r10) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r10);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence r10) {
            this.mIntent.putExtra("android.intent.extra.TEXT", r10);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String r10) {
            this.mIntent.setType(r10);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
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

        public IntentReader(@NonNull Activity r10) {
            this((Context) Preconditions.checkNotNull(r10), r10.getIntent());
        }

        public IntentReader(@NonNull Context r10, @NonNull Intent r11) {
            this.mContext = (Context) Preconditions.checkNotNull(r10);
            this.mIntent = (Intent) Preconditions.checkNotNull(r11);
            this.mCallingPackage = ShareCompat.getCallingPackage(r11);
            this.mCallingActivity = ShareCompat.getCallingActivity(r11);
        }

        @NonNull
        @Deprecated
        public static IntentReader from(@NonNull Activity r10) {
            return new IntentReader(r10);
        }

        private static void withinStyle(StringBuilder r10, CharSequence r11, int r12, int r13) {
        L2:
            if (r12 >= r13) goto L28;
            char r14 = r11.charAt(r12);
            if (r14 != '<') goto L8;
            String r15 = "&lt;";
        L6:
            r10.append(r15);
        L27:
            r12 = r12 + 1;
            goto L2
        L8:
            if (r14 != '>') goto L11;
            r15 = "&gt;";
            goto L6
        L11:
            if (r14 != '&') goto L14;
            r15 = "&amp;";
            goto L6
        L14:
            if (r14 <= '~') goto L16;
        L26:
            r10.append("&#");
            r10.append(r14);
            r15 = ";";
            goto L6
        L16:
            if (r14 < ' ') goto L26;
            if (r14 != ' ') goto L25;
        L19:
            int r16 = r12 + 1;
            if (r16 >= r13) goto L24;
            if (r11.charAt(r16) != ' ') goto L24;
            r10.append("&nbsp;");
            r12 = r16;
        L24:
            r10.append(' ');
            goto L27
        L25:
            r10.append(r14);
            goto L27
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
            PackageManager r10 = this.mContext.getPackageManager();
            return r10.getActivityIcon(this.mCallingActivity);
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
            PackageManager r10 = this.mContext.getPackageManager();
            return r10.getApplicationIcon(this.mCallingPackage);
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
            PackageManager r10 = this.mContext.getPackageManager();
            return r10.getApplicationLabel(r10.getApplicationInfo(this.mCallingPackage, 0));
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
            String r10 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r10 != null) goto L13;
            CharSequence r11 = getText();
            if ((r11 instanceof Spanned) == true) goto L14;
            if (r11 != null) goto L9;
            return r10;
        L9:
            if (Build.VERSION.SDK_INT >= 16) goto L16;
            StringBuilder r12 = new StringBuilder();
            withinStyle(r12, r11, 0, r11.length());
            return r12.toString();
        L16:
            return Api16Impl.escapeHtml(r11);
        L14:
            return Html.toHtml((Spanned) r11);
        L13:
            return r10;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        @Nullable
        public Uri getStream(int r10) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r11 = this.mStreams;
            if (r11 == null) goto L12;
            Object r12 = r11.get(r10);
        L11:
            return (Uri) r12;
        L12:
            if (r10 != 0) goto L15;
            r12 = this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            goto L11
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r10);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r10 = this.mStreams;
            if (r10 == null) goto L12;
            return r10.size();
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
            String r10 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r10) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(@NonNull Menu r10, @IdRes int r11, @NonNull IntentBuilder r12) {
        MenuItem r13 = r10.findItem(r11);
        if (r13 == null) goto L7;
        configureMenuItem(r13, r12);
        return;
    L7:
        throw new IllegalArgumentException("Could not find menu item with id " + r11 + " in the supplied menu");
    }

    @Deprecated
    public static void configureMenuItem(@NonNull MenuItem r10, @NonNull IntentBuilder r11) {
        ActionProvider r12 = r10.getActionProvider();
        if ((r12 instanceof ShareActionProvider) == true) goto L5;
        ShareActionProvider r13 = new ShareActionProvider(r11.getContext());
    L6:
        r13.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + r11.getContext().getClass().getName());
        r13.setShareIntent(r11.getIntent());
        r10.setActionProvider(r13);
        if (Build.VERSION.SDK_INT < 16) goto L9;
        return;
    L9:
        if (r10.hasSubMenu() == true) goto L13;
        r10.setIntent(r11.createChooserIntent());
        return;
    L13:
        return;
    L5:
        r13 = (ShareActionProvider) r12;
        goto L6
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity r10) {
        Intent r11 = r10.getIntent();
        ComponentName r12 = r10.getCallingActivity();
        if (r12 == null) goto L5;
        return r12;
    L5:
        return getCallingActivity(r11);
    }

    @Nullable
    static ComponentName getCallingActivity(@NonNull Intent r10) {
        ComponentName r11 = (ComponentName) r10.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return (ComponentName) r10.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity r10) {
        Intent r11 = r10.getIntent();
        String r12 = r10.getCallingPackage();
        if (r12 != null) goto L7;
        if (r11 != null) goto L6;
        return r12;
    L6:
        return getCallingPackage(r11);
    L7:
        return r12;
    }

    @Nullable
    static String getCallingPackage(@NonNull Intent r10) {
        String r11 = r10.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return r10.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }
}
