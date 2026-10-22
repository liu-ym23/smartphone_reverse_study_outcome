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
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private static class Api16Impl {
        private Api16Impl() {
        }

        static String escapeHtml(CharSequence r2) {
            return Html.escapeHtml((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static void migrateExtraStreamToClipData(Intent r9, ArrayList<Uri> r10) {
            ClipData r2 = new ClipData(null, new String[]{r9.getType()}, new ClipData.Item(r9.getCharSequenceExtra("android.intent.extra.TEXT"), r9.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, (Uri) ZeusTransformUtils.preCheckCast(r10.get(0), Uri.class, "com.obric.memorydata.plugin")));
            int r0 = r10.size();
            int r1 = 1;
        L3:
            if (r1 >= r0) goto L5;
            r2.addItem(new ClipData.Item((Uri) ZeusTransformUtils.preCheckCast(r10.get(r1), Uri.class, "com.obric.memorydata.plugin")));
            r1 = r1 + 1;
            goto L3
        L5:
            r9.setClipData(r2);
            r9.addFlags(1);
        }

        static void removeClipData(Intent r1) {
            r1.setClipData(null);
            r1.setFlags(r1.getFlags() & (-2));
        }
    }

    public static class IntentBuilder {
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        public IntentBuilder(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r6), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            Intent r0 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r0;
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r6.getPackageName());
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r6.getPackageName());
            r0.addFlags(524288);
        L4:
            if (ZeusTransformUtils.instanceOf(r6, ContextWrapper.class) == false) goto L9;
            if (ZeusTransformUtils.instanceOf(r6, Activity.class) == true) goto L7;
            r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r6, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            goto L4
        L7:
            Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.memorydata.plugin");
        L10:
            if (r7 == null) goto L15;
            ComponentName r8 = r7.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r8);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r8);
            return;
        L15:
            return;
        L9:
            r7 = null;
            goto L10
        }

        private void combineArrayExtra(String r5, ArrayList<String> r6) {
            String[] r0 = this.mIntent.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.size() + r2];
            r6.toArray(r3);
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, r6.size(), r2);
        L9:
            this.mIntent.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        private void combineArrayExtra(String r5, String[] r6) {
            Intent r4 = getIntent();
            String[] r0 = r4.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.length + r2];
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, 0, r2);
        L9:
            System.arraycopy(r6, 0, r3, r2, r6.length);
            r4.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        @Deprecated
        public static IntentBuilder from(Activity r2) {
            return new IntentBuilder((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"));
        }

        public IntentBuilder addEmailBcc(String r2) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] r2) {
            combineArrayExtra("android.intent.extra.BCC", r2);
            return this;
        }

        public IntentBuilder addEmailCc(String r2) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] r2) {
            combineArrayExtra("android.intent.extra.CC", r2);
            return this;
        }

        public IntentBuilder addEmailTo(String r2) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] r2) {
            combineArrayExtra("android.intent.extra.EMAIL", r2);
            return this;
        }

        public IntentBuilder addStream(Uri r2) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r2);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        Context getContext() {
            return this.mContext;
        }

        public Intent getIntent() {
            ArrayList<String> r0 = this.mToAddresses;
            if (r0 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r0);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r1 = this.mCcAddresses;
            if (r1 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r1);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r2 = this.mBccAddresses;
            if (r2 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r2);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r3 = this.mStreams;
            boolean r4 = true;
            if (r3 != null) goto L14;
        L16:
            r4 = false;
        L18:
            if (r4 == true) goto L29;
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r5 = this.mStreams;
            if (r5 != null) goto L22;
        L26:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            if (Build.VERSION.SDK_INT < 16) goto L33;
            Api16Impl.removeClipData(this.mIntent);
        L33:
            return this.mIntent;
        L22:
            if (r5.isEmpty() == true) goto L26;
            this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(this.mStreams.get(0), Parcelable.class, "com.obric.memorydata.plugin"));
            if (Build.VERSION.SDK_INT < 16) goto L33;
        L31:
            Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L33
        L29:
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            if (Build.VERSION.SDK_INT < 16) goto L33;
        L14:
            if (r3.size() <= 1) goto L16;
            goto L16
        }

        public IntentBuilder setChooserTitle(int r2) {
            return setChooserTitle(this.mContext.getText(r2));
        }

        public IntentBuilder setChooserTitle(CharSequence r3) {
            this.mChooserTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public IntentBuilder setEmailBcc(String[] r3) {
            this.mIntent.putExtra("android.intent.extra.BCC", r3);
            return this;
        }

        public IntentBuilder setEmailCc(String[] r3) {
            this.mIntent.putExtra("android.intent.extra.CC", r3);
            return this;
        }

        public IntentBuilder setEmailTo(String[] r3) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r3);
            return this;
        }

        public IntentBuilder setHtmlText(String r3) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r3);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r3));
        L5:
            return this;
        }

        public IntentBuilder setStream(Uri r2) {
            this.mStreams = null;
            if (r2 == null) goto L5;
            addStream(r2);
        L5:
            return this;
        }

        public IntentBuilder setSubject(String r3) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r3);
            return this;
        }

        public IntentBuilder setText(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.mIntent.putExtra("android.intent.extra.TEXT", r4);
            return this;
        }

        public IntentBuilder setType(String r2) {
            this.mIntent.setType(r2);
            return this;
        }

        public void startChooser() {
            ZeusTransformUtils.startActivity(this.mContext, createChooserIntent(), "com.obric.memorydata.plugin");
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;

        public IntentReader(Activity r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
            this((Context) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5), Context.class, "com.obric.memorydata.plugin"), r5.getIntent());
        }

        public IntentReader(Context r3, Intent r4) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.mIntent = (Intent) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4), Intent.class, "com.obric.memorydata.plugin");
            this.mCallingPackage = ShareCompat.getCallingPackage(r4);
            this.mCallingActivity = ShareCompat.getCallingActivity(r4);
        }

        @Deprecated
        public static IntentReader from(Activity r2) {
            return new IntentReader((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"));
        }

        private static void withinStyle(StringBuilder r3, CharSequence r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        L3:
            if (r5 >= r6) goto L29;
            char r0 = r7.charAt(r5);
            if (r0 != '<') goto L9;
            String r1 = "&lt;";
        L7:
            r3.append(r1);
        L28:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r0 != '>') goto L12;
            r1 = "&gt;";
            goto L7
        L12:
            if (r0 != '&') goto L15;
            r1 = "&amp;";
            goto L7
        L15:
            if (r0 <= '~') goto L17;
        L27:
            r3.append("&#").append(r0).append(";");
            goto L28
        L17:
            if (r0 < ' ') goto L27;
            if (r0 != ' ') goto L26;
        L20:
            int r2 = r5 + 1;
            if (r2 >= r6) goto L25;
            if (r7.charAt(r2) != ' ') goto L25;
            r3.append("&nbsp;");
            r5 = r2;
        L25:
            r3.append(' ');
            goto L28
        L26:
            r3.append(r0);
            goto L28
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getActivityIcon(this.mCallingActivity);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling activity", e);
            return null;
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationIcon(this.mCallingPackage);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling application", e);
            return null;
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationLabel(r0.getApplicationInfo(this.mCallingPackage, 0));
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve label for calling application", e);
            return null;
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String r0 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r0 != null) goto L13;
            CharSequence r3 = getText();
            if (ZeusTransformUtils.instanceOf(r3, Spanned.class) == true) goto L14;
            if (r3 != null) goto L9;
            return r0;
        L9:
            if (Build.VERSION.SDK_INT >= 16) goto L16;
            StringBuilder r1 = new StringBuilder();
            withinStyle(r1, r3, 0, r3.length());
            return r1.toString();
        L16:
            return Api16Impl.escapeHtml(r3);
        L14:
            return Html.toHtml((Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin"));
        L13:
            return r0;
        }

        public Uri getStream() {
            return (Uri) ZeusTransformUtils.preCheckCast(this.mIntent.getParcelableExtra("android.intent.extra.STREAM"), Uri.class, "com.obric.memorydata.plugin");
        }

        public Uri getStream(int r4) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 == null) goto L12;
            Object r3 = r0.get(r4);
        L11:
            return (Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin");
        L12:
            if (r4 != 0) goto L15;
            r3 = this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            goto L11
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r4);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 == null) goto L12;
            return r0.size();
        L12:
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String r1 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r1) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r1) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(Menu r2, int r3, IntentBuilder r4) {
        MenuItem r5 = ((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).findItem(r3);
        if (r5 == null) goto L7;
        configureMenuItem(r5, r4);
        return;
    L7:
        throw new IllegalArgumentException("Could not find menu item with id " + r3 + " in the supplied menu");
    }

    @Deprecated
    public static void configureMenuItem(MenuItem r5, IntentBuilder r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r5, MenuItem.class, "com.obric.memorydata.plugin");
        ActionProvider r0 = r7.getActionProvider();
        if (ZeusTransformUtils.instanceOf(r0, ShareActionProvider.class) == true) goto L5;
        ShareActionProvider r1 = new ShareActionProvider((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        r1.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClass().getName());
        r1.setShareIntent(r6.getIntent());
        r7.setActionProvider(r1);
        if (Build.VERSION.SDK_INT < 16) goto L9;
        return;
    L9:
        if (r7.hasSubMenu() == true) goto L13;
        r7.setIntent(r6.createChooserIntent());
        return;
    L13:
        return;
    L5:
        r1 = (ShareActionProvider) ZeusTransformUtils.preCheckCast(r0, ShareActionProvider.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static ComponentName getCallingActivity(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Intent r0 = r3.getIntent();
        ComponentName r4 = r3.getCallingActivity();
        if (r4 == null) goto L5;
        return r4;
    L5:
        return getCallingActivity(r0);
    }

    static ComponentName getCallingActivity(Intent r3) {
        ComponentName r0 = (ComponentName) ZeusTransformUtils.preCheckCast(r3.getParcelableExtra(EXTRA_CALLING_ACTIVITY), ComponentName.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ComponentName) ZeusTransformUtils.preCheckCast(r3.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP), ComponentName.class, "com.obric.memorydata.plugin");
    }

    public static String getCallingPackage(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Intent r0 = r3.getIntent();
        String r4 = r3.getCallingPackage();
        if (r4 != null) goto L7;
        if (r0 != null) goto L6;
        return r4;
    L6:
        return getCallingPackage(r0);
    L7:
        return r4;
    }

    static String getCallingPackage(Intent r1) {
        String r0 = r1.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }
}
