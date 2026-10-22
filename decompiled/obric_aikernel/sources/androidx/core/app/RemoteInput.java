package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ClipData getClipData(Intent r10) {
            return r10.getClipData();
        }

        @DoNotInline
        static void setClipData(Intent r10, ClipData r11) {
            r10.setClipData(r11);
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static void addResultsToIntent(Object r10, Intent r11, Bundle r12) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) r10, r11, r12);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r10) {
            android.app.RemoteInput.Builder r11 = new android.app.RemoteInput.Builder(r10.getResultKey()).setLabel(r10.getLabel()).setChoices(r10.getChoices()).setAllowFreeFormInput(r10.getAllowFreeFormInput()).addExtras(r10.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r12 = r10.getAllowedDataTypes();
            if (r12 == null) goto L11;
            Iterator<String> r13 = r12.iterator();
        L8:
            if (r13.hasNext() == false) goto L11;
            Api26Impl.setAllowDataType(r11, r13.next(), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            Api29Impl.setEditChoicesBeforeSending(r11, r10.getEditChoicesBeforeSending());
        L14:
            return r11.build();
        }

        static RemoteInput fromPlatform(Object r10) {
            android.app.RemoteInput r11 = (android.app.RemoteInput) r10;
            Builder r12 = new Builder(r11.getResultKey()).setLabel(r11.getLabel()).setChoices(r11.getChoices()).setAllowFreeFormInput(r11.getAllowFreeFormInput()).addExtras(r11.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r13 = Api26Impl.getAllowedDataTypes(r11);
            if (r13 == null) goto L11;
            Iterator<String> r14 = r13.iterator();
        L8:
            if (r14.hasNext() == false) goto L11;
            r12.setAllowDataType(r14.next(), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            r12.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r11));
        L14:
            return r12.build();
        }

        @DoNotInline
        static Bundle getResultsFromIntent(Intent r10) {
            return android.app.RemoteInput.getResultsFromIntent(r10);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void addDataResultToIntent(RemoteInput r10, Intent r11, Map<String, Uri> r12) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r10), r11, r12);
        }

        @DoNotInline
        static Set<String> getAllowedDataTypes(Object r10) {
            return ((android.app.RemoteInput) r10).getAllowedDataTypes();
        }

        @DoNotInline
        static Map<String, Uri> getDataResultsFromIntent(Intent r10, String r11) {
            return android.app.RemoteInput.getDataResultsFromIntent(r10, r11);
        }

        @DoNotInline
        static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r10, String r11, boolean r12) {
            return r10.setAllowDataType(r11, r12);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getResultsSource(Intent r10) {
            return android.app.RemoteInput.getResultsSource(r10);
        }

        @DoNotInline
        static void setResultsSource(Intent r10, int r11) {
            android.app.RemoteInput.setResultsSource(r10, r11);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getEditChoicesBeforeSending(Object r10) {
            return ((android.app.RemoteInput) r10).getEditChoicesBeforeSending();
        }

        @DoNotInline
        static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r10, int r11) {
            return r10.setEditChoicesBeforeSending(r11);
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

        public Builder(@NonNull String r10) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r10 == null) goto L7;
            this.mResultKey = r10;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle r10) {
            if (r10 == null) goto L4;
            this.mExtras.putAll(r10);
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
        public Builder setAllowDataType(@NonNull String r10, boolean r11) {
            if (r11 == false) goto L4;
            this.mAllowedDataTypes.add(r10);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r10);
            goto L5
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean r10) {
            this.mAllowFreeFormTextInput = r10;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] r10) {
            this.mChoices = r10;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int r10) {
            this.mEditChoicesBeforeSending = r10;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence r10) {
            this.mLabel = r10;
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

    RemoteInput(String r10, CharSequence r11, CharSequence[] r12, boolean r13, int r14, Bundle r15, Set<String> r16) {
        this.mResultKey = r10;
        this.mLabel = r11;
        this.mChoices = r12;
        this.mAllowFreeFormTextInput = r13;
        this.mEditChoicesBeforeSending = r14;
        this.mExtras = r15;
        this.mAllowedDataTypes = r16;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    public static void addDataResultToIntent(@NonNull RemoteInput r10, @NonNull Intent r11, @NonNull Map<String, Uri> r12) {
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 26) goto L6;
        Api26Impl.addDataResultToIntent(r10, r11, r12);
        return;
    L6:
        if (r13 < 16) goto L28;
        Intent r14 = getClipDataIntentFromIntent(r11);
        if (r14 != null) goto L10;
        r14 = new Intent();
    L10:
        Iterator<Map.Entry<String, Uri>> r15 = r12.entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L20;
        Map.Entry<String, Uri> r16 = r15.next();
        String r17 = r16.getKey();
        Uri r18 = r16.getValue();
        if (r17 == null) goto L12;
        Bundle r19 = r14.getBundleExtra(getExtraResultsKeyForData(r17));
        if (r19 != null) goto L19;
        r19 = new Bundle();
    L19:
        r19.putString(r10.getResultKey(), r18.toString());
        r14.putExtra(getExtraResultsKeyForData(r17), r19);
        goto L12
    L20:
        Api16Impl.setClipData(r11, ClipData.newIntent(RESULTS_CLIP_LABEL, r14));
        return;
    }

    public static void addResultsToIntent(@NonNull RemoteInput[] r10, @NonNull Intent r11, @NonNull Bundle r12) {
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 26) goto L5;
        Api20Impl.addResultsToIntent(fromCompat(r10), r11, r12);
        return;
    L5:
        int r14 = 0;
        if (r13 < 20) goto L19;
        Bundle r15 = getResultsFromIntent(r11);
        int r16 = getResultsSource(r11);
        if (r15 == null) goto L11;
        r15.putAll(r12);
        r12 = r15;
    L11:
        int r17 = r10.length;
        int r18 = 0;
    L12:
        if (r18 >= r17) goto L17;
        RemoteInput r19 = r10[r18];
        Map<String, Uri> r20 = getDataResultsFromIntent(r11, r19.getResultKey());
        Api20Impl.addResultsToIntent(fromCompat(new RemoteInput[]{r19}), r11, r12);
        if (r20 == null) goto L16;
        addDataResultToIntent(r19, r11, r20);
    L16:
        r18 = r18 + 1;
        goto L12
    L17:
        setResultsSource(r11, r16);
        return;
    L19:
        if (r13 < 16) goto L42;
        Intent r21 = getClipDataIntentFromIntent(r11);
        if (r21 != null) goto L23;
        r21 = new Intent();
    L23:
        Bundle r22 = r21.getBundleExtra(EXTRA_RESULTS_DATA);
        if (r22 != null) goto L26;
        r22 = new Bundle();
    L26:
        int r23 = r10.length;
    L27:
        if (r14 >= r23) goto L32;
        RemoteInput r24 = r10[r14];
        Object r25 = r12.get(r24.getResultKey());
        if ((r25 instanceof CharSequence) == false) goto L31;
        r22.putCharSequence(r24.getResultKey(), (CharSequence) r25);
    L31:
        r14 = r14 + 1;
        goto L27
    L32:
        r21.putExtra(EXTRA_RESULTS_DATA, r22);
        Api16Impl.setClipData(r11, ClipData.newIntent(RESULTS_CLIP_LABEL, r21));
        return;
    }

    @RequiresApi(20)
    static android.app.RemoteInput fromCompat(RemoteInput r10) {
        return Api20Impl.fromCompat(r10);
    }

    @RequiresApi(20)
    static android.app.RemoteInput[] fromCompat(RemoteInput[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r11 = new android.app.RemoteInput[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = fromCompat(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    @RequiresApi(20)
    static RemoteInput fromPlatform(android.app.RemoteInput r10) {
        return Api20Impl.fromPlatform(r10);
    }

    @RequiresApi(16)
    private static Intent getClipDataIntentFromIntent(Intent r10) {
        ClipData r11 = Api16Impl.getClipData(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        ClipDescription r12 = r11.getDescription();
        if (r12.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r12.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r11.getItemAt(0).getIntent();
    }

    @Nullable
    public static Map<String, Uri> getDataResultsFromIntent(@NonNull Intent r10, @NonNull String r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 26) goto L7;
        return Api26Impl.getDataResultsFromIntent(r10, r11);
    L7:
        if (r12 < 16) goto L41;
        Intent r13 = getClipDataIntentFromIntent(r10);
        if (r13 != null) goto L11;
        return null;
    L11:
        HashMap r14 = new HashMap();
        Iterator<String> r15 = r13.getExtras().keySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L26;
        String r16 = r15.next();
        if (r16.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) == false) goto L13;
        String r17 = r16.substring(39);
        if (r17.isEmpty() == true) goto L13;
        String r18 = r13.getBundleExtra(r16).getString(r11);
        if (r18 == null) goto L13;
        if (r18.isEmpty() == true) goto L13;
        r14.put(r17, Uri.parse(r18));
        goto L13
    L26:
        if (r14.isEmpty() == false) goto L29;
        return null;
    L29:
        return r14;
    L41:
        return null;
    }

    private static String getExtraResultsKeyForData(String r10) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + r10;
    }

    @Nullable
    public static Bundle getResultsFromIntent(@NonNull Intent r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L7;
        return Api20Impl.getResultsFromIntent(r10);
    L7:
        if (r11 < 16) goto L13;
        Intent r12 = getClipDataIntentFromIntent(r10);
        if (r12 != null) goto L12;
        return null;
    L12:
        return (Bundle) r12.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    L13:
        return null;
    }

    public static int getResultsSource(@NonNull Intent r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        return Api28Impl.getResultsSource(r10);
    L7:
        if (r11 < 16) goto L13;
        Intent r12 = getClipDataIntentFromIntent(r10);
        if (r12 != null) goto L12;
        return 0;
    L12:
        return r12.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    L13:
        return 0;
    }

    public static void setResultsSource(@NonNull Intent r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L6;
        Api28Impl.setResultsSource(r10, r11);
        return;
    L6:
        if (r12 < 16) goto L13;
        Intent r13 = getClipDataIntentFromIntent(r10);
        if (r13 != null) goto L10;
        r13 = new Intent();
    L10:
        r13.putExtra(EXTRA_RESULTS_SOURCE, r11);
        Api16Impl.setClipData(r10, ClipData.newIntent(RESULTS_CLIP_LABEL, r13));
        return;
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
}
