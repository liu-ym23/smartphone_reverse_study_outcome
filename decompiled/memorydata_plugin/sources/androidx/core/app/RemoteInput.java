package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static class Api16Impl {
        private Api16Impl() {
        }

        static ClipData getClipData(Intent r0) {
            return r0.getClipData();
        }

        static void setClipData(Intent r0, ClipData r1) {
            r0.setClipData(r1);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static void addResultsToIntent(Object r2, Intent r3, Bundle r4) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) ZeusTransformUtils.preCheckCast(r2, android.app.RemoteInput[].class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r5) {
            android.app.RemoteInput.Builder r0 = new android.app.RemoteInput.Builder(r5.getResultKey()).setLabel(r5.getLabel()).setChoices(r5.getChoices()).setAllowFreeFormInput(r5.getAllowFreeFormInput()).addExtras(r5.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r1 = r5.getAllowedDataTypes();
            if (r1 == null) goto L11;
            Iterator<String> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L11;
            Api26Impl.setAllowDataType(r0, (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            Api29Impl.setEditChoicesBeforeSending(r0, r5.getEditChoicesBeforeSending());
        L14:
            return r0.build();
        }

        static RemoteInput fromPlatform(Object r5) {
            android.app.RemoteInput r6 = (android.app.RemoteInput) ZeusTransformUtils.preCheckCast(r5, android.app.RemoteInput.class, "com.obric.memorydata.plugin");
            Builder r0 = new Builder(r6.getResultKey()).setLabel(r6.getLabel()).setChoices(r6.getChoices()).setAllowFreeFormInput(r6.getAllowFreeFormInput()).addExtras(r6.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r2 = Api26Impl.getAllowedDataTypes(r6);
            if (r2 == null) goto L11;
            Iterator<String> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            r0.setAllowDataType((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            r0.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r6));
        L14:
            return r0.build();
        }

        static Bundle getResultsFromIntent(Intent r0) {
            return android.app.RemoteInput.getResultsFromIntent(r0);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void addDataResultToIntent(RemoteInput r2, Intent r3, Map<String, Uri> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r2), r3, r5);
        }

        static Set<String> getAllowedDataTypes(Object r2) {
            return ((android.app.RemoteInput) ZeusTransformUtils.preCheckCast(r2, android.app.RemoteInput.class, "com.obric.memorydata.plugin")).getAllowedDataTypes();
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent r0, String r1) {
            return android.app.RemoteInput.getDataResultsFromIntent(r0, r1);
        }

        static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r0, String r1, boolean r2) {
            return r0.setAllowDataType(r1, r2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getResultsSource(Intent r0) {
            return android.app.RemoteInput.getResultsSource(r0);
        }

        static void setResultsSource(Intent r0, int r1) {
            android.app.RemoteInput.setResultsSource(r0, r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int getEditChoicesBeforeSending(Object r2) {
            return ((android.app.RemoteInput) ZeusTransformUtils.preCheckCast(r2, android.app.RemoteInput.class, "com.obric.memorydata.plugin")).getEditChoicesBeforeSending();
        }

        static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r0, int r1) {
            return r0.setEditChoicesBeforeSending(r1);
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

        public Builder(String r2) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r2 == null) goto L7;
            this.mResultKey = r2;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder addExtras(Bundle r2) {
            if (r2 == null) goto L4;
            this.mExtras.putAll(r2);
        L4:
            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder setAllowDataType(String r1, boolean r2) {
            if (r2 == false) goto L4;
            this.mAllowedDataTypes.add(r1);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r1);
            goto L5
        }

        public Builder setAllowFreeFormInput(boolean r1) {
            this.mAllowFreeFormTextInput = r1;
            return this;
        }

        public Builder setChoices(CharSequence[] r1) {
            this.mChoices = r1;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int r1) {
            this.mEditChoicesBeforeSending = r1;
            return this;
        }

        public Builder setLabel(CharSequence r3) {
            this.mLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    RemoteInput(String r3, CharSequence r4, CharSequence[] r5, boolean r6, int r7, Bundle r8, Set<String> r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        this.mResultKey = r3;
        this.mLabel = r10;
        this.mChoices = r5;
        this.mAllowFreeFormTextInput = r6;
        this.mEditChoicesBeforeSending = r7;
        this.mExtras = r8;
        this.mAllowedDataTypes = r11;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    public static void addDataResultToIntent(RemoteInput r6, Intent r7, Map<String, Uri> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.addDataResultToIntent(r6, r7, r9);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L28;
        Intent r0 = getClipDataIntentFromIntent(r7);
        if (r0 != null) goto L10;
        r0 = new Intent();
    L10:
        Iterator r10 = r9.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        Uri r4 = (Uri) ZeusTransformUtils.preCheckCast(r2.getValue(), Uri.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        Bundle r5 = r0.getBundleExtra(getExtraResultsKeyForData(r3));
        if (r5 != null) goto L19;
        r5 = new Bundle();
    L19:
        r5.putString(r6.getResultKey(), r4.toString());
        r0.putExtra(getExtraResultsKeyForData(r3), r5);
        goto L12
    L20:
        Api16Impl.setClipData(r7, ClipData.newIntent(RESULTS_CLIP_LABEL, r0));
        return;
    }

    public static void addResultsToIntent(RemoteInput[] r9, Intent r10, Bundle r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api20Impl.addResultsToIntent(fromCompat(r9), r10, r11);
        return;
    L5:
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 20) goto L19;
        Bundle r0 = getResultsFromIntent(r10);
        int r1 = getResultsSource(r10);
        if (r0 == null) goto L11;
        r0.putAll(r11);
        r11 = r0;
    L11:
        int r3 = r9.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L17;
        RemoteInput r5 = r9[r4];
        Map<String, Uri> r6 = getDataResultsFromIntent(r10, r5.getResultKey());
        Api20Impl.addResultsToIntent(fromCompat(new RemoteInput[]{r5}), r10, r11);
        if (r6 == null) goto L16;
        addDataResultToIntent(r5, r10, r6);
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        setResultsSource(r10, r1);
        return;
    L19:
        if (Build.VERSION.SDK_INT < 16) goto L42;
        Intent r7 = getClipDataIntentFromIntent(r10);
        if (r7 != null) goto L23;
        r7 = new Intent();
    L23:
        Bundle r8 = r7.getBundleExtra(EXTRA_RESULTS_DATA);
        if (r8 != null) goto L26;
        r8 = new Bundle();
    L26:
        int r12 = r9.length;
    L27:
        if (r2 >= r12) goto L32;
        RemoteInput r13 = r9[r2];
        Object r14 = r11.get(r13.getResultKey());
        if (ZeusTransformUtils.instanceOf(r14, CharSequence.class) == false) goto L31;
        r8.putCharSequence(r13.getResultKey(), (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
    L31:
        r2 = r2 + 1;
        goto L27
    L32:
        r7.putExtra(EXTRA_RESULTS_DATA, r8);
        Api16Impl.setClipData(r10, ClipData.newIntent(RESULTS_CLIP_LABEL, r7));
        return;
    }

    static android.app.RemoteInput fromCompat(RemoteInput r0) {
        return Api20Impl.fromCompat(r0);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r0 = new android.app.RemoteInput[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = fromCompat(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static RemoteInput fromPlatform(android.app.RemoteInput r0) {
        return Api20Impl.fromPlatform(r0);
    }

    private static Intent getClipDataIntentFromIntent(Intent r3) {
        ClipData r4 = Api16Impl.getClipData(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        ClipDescription r1 = r4.getDescription();
        if (r1.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r1.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r4.getItemAt(0).getIntent();
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent r6, String r7) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getDataResultsFromIntent(r6, r7);
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L41;
        Intent r8 = getClipDataIntentFromIntent(r6);
        if (r8 != null) goto L11;
        return null;
    L11:
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r8.getExtras().keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L26;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) == false) goto L13;
        String r4 = r3.substring(39);
        if (r4.isEmpty() == true) goto L13;
        String r5 = r8.getBundleExtra(r3).getString(r7);
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        r0.put(r4, Uri.parse(r5));
        goto L13
    L26:
        if (r0.isEmpty() == false) goto L29;
        return null;
    L29:
        return r0;
    L41:
        return null;
    }

    private static String getExtraResultsKeyForData(String r2) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + r2;
    }

    public static Bundle getResultsFromIntent(Intent r3) {
        if (Build.VERSION.SDK_INT < 20) goto L7;
        return Api20Impl.getResultsFromIntent(r3);
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        Intent r4 = getClipDataIntentFromIntent(r3);
        if (r4 != null) goto L12;
        return null;
    L12:
        return (Bundle) ZeusTransformUtils.preCheckCast(r4.getExtras().getParcelable(EXTRA_RESULTS_DATA), Bundle.class, "com.obric.memorydata.plugin");
    L13:
        return null;
    }

    public static int getResultsSource(Intent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getResultsSource(r3);
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        Intent r4 = getClipDataIntentFromIntent(r3);
        if (r4 != null) goto L12;
        return 0;
    L12:
        return r4.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    L13:
        return 0;
    }

    public static void setResultsSource(Intent r2, int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setResultsSource(r2, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        Intent r0 = getClipDataIntentFromIntent(r2);
        if (r0 != null) goto L10;
        r0 = new Intent();
    L10:
        r0.putExtra(EXTRA_RESULTS_SOURCE, r3);
        Api16Impl.setClipData(r2, ClipData.newIntent(RESULTS_CLIP_LABEL, r0));
        return;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

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
