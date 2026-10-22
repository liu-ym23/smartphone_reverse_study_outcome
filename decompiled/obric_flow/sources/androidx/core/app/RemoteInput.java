package androidx.core.app;

import ai.j0;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    @RequiresApi(20)
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static void addResultsToIntent(Object r5, Intent r10, Bundle r11) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) r5, r10, r11);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r5) {
            android.app.RemoteInput.Builder r10 = new android.app.RemoteInput.Builder(r5.getResultKey()).setLabel(r5.getLabel()).setChoices(r5.getChoices()).setAllowFreeFormInput(r5.getAllowFreeFormInput()).addExtras(r5.getExtras());
            Set<String> r11 = r5.getAllowedDataTypes();
            if (r11 == null) goto L8;
            Iterator<String> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            Api26Impl.setAllowDataType(r10, r12.next(), true);
        L8:
            Api29Impl.setEditChoicesBeforeSending(r10, r5.getEditChoicesBeforeSending());
            return r10.build();
        }

        public static RemoteInput fromPlatform(Object r5) {
            android.app.RemoteInput r10 = (android.app.RemoteInput) r5;
            Builder r11 = new Builder(r10.getResultKey()).setLabel(r10.getLabel()).setChoices(r10.getChoices()).setAllowFreeFormInput(r10.getAllowFreeFormInput()).addExtras(r10.getExtras());
            Set<String> r12 = Api26Impl.getAllowedDataTypes(r10);
            if (r12 == null) goto L8;
            Iterator<String> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            r11.setAllowDataType(r13.next(), true);
        L8:
            r11.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r10));
            return r11.build();
        }

        @DoNotInline
        public static Bundle getResultsFromIntent(Intent r5) {
            return android.app.RemoteInput.getResultsFromIntent(r5);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void addDataResultToIntent(RemoteInput r5, Intent r10, Map<String, Uri> r11) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r5), r10, r11);
        }

        @DoNotInline
        public static Set<String> getAllowedDataTypes(Object r5) {
            return ((android.app.RemoteInput) r5).getAllowedDataTypes();
        }

        @DoNotInline
        public static Map<String, Uri> getDataResultsFromIntent(Intent r5, String r10) {
            return android.app.RemoteInput.getDataResultsFromIntent(r5, r10);
        }

        @DoNotInline
        public static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r5, String r10, boolean r11) {
            return r5.setAllowDataType(r10, r11);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int getResultsSource(Intent r5) {
            return android.app.RemoteInput.getResultsSource(r5);
        }

        @DoNotInline
        public static void setResultsSource(Intent r5, int r10) {
            android.app.RemoteInput.setResultsSource(r5, r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getEditChoicesBeforeSending(Object r5) {
            return ((android.app.RemoteInput) r5).getEditChoicesBeforeSending();
        }

        @DoNotInline
        public static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r5, int r10) {
            return r5.setEditChoicesBeforeSending(r10);
        }
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput;
        private final Set<String> mAllowedDataTypes;
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending;
        private final Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(@NonNull String r5) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r5 == null) goto L7;
            this.mResultKey = r5;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle r5) {
            if (r5 == null) goto L4;
            this.mExtras.putAll(r5);
        L4:
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        @NonNull
        public Bundle getExtras() {
            return this.mExtras;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String r5, boolean r10) {
            if (r10 == false) goto L4;
            this.mAllowedDataTypes.add(r5);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r5);
            goto L5
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean r5) {
            this.mAllowFreeFormTextInput = r5;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] r5) {
            this.mChoices = r5;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int r5) {
            this.mEditChoicesBeforeSending = r5;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence r5) {
            this.mLabel = r5;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    public RemoteInput(String r5, CharSequence r10, CharSequence[] r11, boolean r12, int r13, Bundle r14, Set<String> r15) {
        this.mResultKey = r5;
        this.mLabel = r10;
        this.mChoices = r11;
        this.mAllowFreeFormTextInput = r12;
        this.mEditChoicesBeforeSending = r13;
        this.mExtras = r14;
        this.mAllowedDataTypes = r15;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    public static void addDataResultToIntent(@NonNull RemoteInput r5, @NonNull Intent r10, @NonNull Map<String, Uri> r11) {
        Api26Impl.addDataResultToIntent(r5, r10, r11);
    }

    public static void addResultsToIntent(@NonNull RemoteInput[] r5, @NonNull Intent r10, @NonNull Bundle r11) {
        Api20Impl.addResultsToIntent(fromCompat(r5), r10, r11);
    }

    @RequiresApi(20)
    public static android.app.RemoteInput[] fromCompat(RemoteInput[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r10 = new android.app.RemoteInput[r5.length];
        int r11 = 0;
    L7:
        if (r11 >= r5.length) goto L9;
        r10[r11] = fromCompat(r5[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    @RequiresApi(20)
    public static RemoteInput fromPlatform(android.app.RemoteInput r5) {
        return Api20Impl.fromPlatform(r5);
    }

    private static Intent getClipDataIntentFromIntent(Intent r5) {
        ClipData r10 = r5.getClipData();
        if (r10 != null) goto L5;
        return null;
    L5:
        ClipDescription r11 = r10.getDescription();
        if (r11.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r11.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r10.getItemAt(0).getIntent();
    }

    @Nullable
    public static Map<String, Uri> getDataResultsFromIntent(@NonNull Intent r5, @NonNull String r10) {
        return Api26Impl.getDataResultsFromIntent(r5, r10);
    }

    private static String getExtraResultsKeyForData(String r5) {
        return j0.C(EXTRA_DATA_TYPE_RESULTS_DATA, r5);
    }

    @Nullable
    public static Bundle getResultsFromIntent(@NonNull Intent r5) {
        return Api20Impl.getResultsFromIntent(r5);
    }

    public static int getResultsSource(@NonNull Intent r5) {
        return Api28Impl.getResultsSource(r5);
    }

    public static void setResultsSource(@NonNull Intent r5, int r10) {
        Api28Impl.setResultsSource(r5, r10);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    @Nullable
    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    @Nullable
    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public CharSequence getLabel() {
        return this.mLabel;
    }

    @NonNull
    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        if (getAllowFreeFormInput() == false) goto L5;
    L13:
        return false;
    L5:
        if (getChoices() == null) goto L9;
        if (getChoices().length != 0) goto L13;
    L9:
        if (getAllowedDataTypes() == null) goto L13;
        if (getAllowedDataTypes().isEmpty() == true) goto L13;
        return true;
    }

    @RequiresApi(20)
    public static android.app.RemoteInput fromCompat(RemoteInput r5) {
        return Api20Impl.fromCompat(r5);
    }
}
