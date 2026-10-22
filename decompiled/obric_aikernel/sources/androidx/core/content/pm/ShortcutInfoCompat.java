package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;

    @Nullable
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        static void setExcludedFromSurfaces(@NonNull ShortcutInfo.Builder r10, int r11) {
            r10.setExcludedFromSurfaces(r11);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context r10, @NonNull ShortcutInfo r11) {
            ShortcutInfoCompat r12 = new ShortcutInfoCompat();
            this.mInfo = r12;
            r12.mContext = r10;
            r12.mId = r11.getId();
            r12.mPackageName = r11.getPackage();
            Intent[] r13 = r11.getIntents();
            r12.mIntents = (Intent[]) Arrays.copyOf(r13, r13.length);
            r12.mActivity = r11.getActivity();
            r12.mLabel = r11.getShortLabel();
            r12.mLongLabel = r11.getLongLabel();
            r12.mDisabledMessage = r11.getDisabledMessage();
            int r14 = Build.VERSION.SDK_INT;
            if (r14 < 28) goto L7;
            int r15 = r11.getDisabledReason();
        L5:
            r12.mDisabledReason = r15;
            r12.mCategories = r11.getCategories();
            r12.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r11.getExtras());
            r12.mUser = r11.getUserHandle();
            r12.mLastChangedTimestamp = r11.getLastChangedTimestamp();
            if (r14 < 30) goto L13;
            r12.mIsCached = r11.isCached();
        L13:
            r12.mIsDynamic = r11.isDynamic();
            r12.mIsPinned = r11.isPinned();
            r12.mIsDeclaredInManifest = r11.isDeclaredInManifest();
            r12.mIsImmutable = r11.isImmutable();
            r12.mIsEnabled = r11.isEnabled();
            r12.mHasKeyFieldsOnly = r11.hasKeyFieldsOnly();
            r12.mLocusId = ShortcutInfoCompat.getLocusId(r11);
            r12.mRank = r11.getRank();
            r12.mExtras = r11.getExtras();
            return;
        L7:
            if (r11.isEnabled() == false) goto L9;
            r15 = 0;
            goto L5
        L9:
            r15 = 3;
            goto L5
        }

        public Builder(@NonNull Context r10, @NonNull String r11) {
            ShortcutInfoCompat r12 = new ShortcutInfoCompat();
            this.mInfo = r12;
            r12.mContext = r10;
            r12.mId = r11;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat r10) {
            ShortcutInfoCompat r11 = new ShortcutInfoCompat();
            this.mInfo = r11;
            r11.mContext = r10.mContext;
            r11.mId = r10.mId;
            r11.mPackageName = r10.mPackageName;
            Intent[] r12 = r10.mIntents;
            r11.mIntents = (Intent[]) Arrays.copyOf(r12, r12.length);
            r11.mActivity = r10.mActivity;
            r11.mLabel = r10.mLabel;
            r11.mLongLabel = r10.mLongLabel;
            r11.mDisabledMessage = r10.mDisabledMessage;
            r11.mDisabledReason = r10.mDisabledReason;
            r11.mIcon = r10.mIcon;
            r11.mIsAlwaysBadged = r10.mIsAlwaysBadged;
            r11.mUser = r10.mUser;
            r11.mLastChangedTimestamp = r10.mLastChangedTimestamp;
            r11.mIsCached = r10.mIsCached;
            r11.mIsDynamic = r10.mIsDynamic;
            r11.mIsPinned = r10.mIsPinned;
            r11.mIsDeclaredInManifest = r10.mIsDeclaredInManifest;
            r11.mIsImmutable = r10.mIsImmutable;
            r11.mIsEnabled = r10.mIsEnabled;
            r11.mLocusId = r10.mLocusId;
            r11.mIsLongLived = r10.mIsLongLived;
            r11.mHasKeyFieldsOnly = r10.mHasKeyFieldsOnly;
            r11.mRank = r10.mRank;
            Person[] r13 = r10.mPersons;
            if (r13 == null) goto L6;
            r11.mPersons = (Person[]) Arrays.copyOf(r13, r13.length);
        L6:
            if (r10.mCategories == null) goto L8;
            r11.mCategories = new HashSet(r10.mCategories);
        L8:
            PersistableBundle r14 = r10.mExtras;
            if (r14 == null) goto L11;
            r11.mExtras = r14;
        L11:
            r11.mExcludedSurfaces = r10.mExcludedSurfaces;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r10) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r10, @NonNull String r11, @NonNull List<String> r12) {
            addCapabilityBinding(r10);
            if (r12.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r10) != null) goto L10;
            this.mCapabilityBindingParams.put(r10, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r10).put(r11, r12);
            goto L11
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L49;
            ShortcutInfoCompat r10 = this.mInfo;
            Intent[] r11 = r10.mIntents;
            if (r11 == null) goto L47;
            if (r11.length == 0) goto L47;
            if (this.mIsConversation == false) goto L15;
            if (r10.mLocusId != null) goto L13;
            r10.mLocusId = new LocusIdCompat(r10.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            ShortcutInfoCompat r12 = this.mInfo;
            if (r12.mCategories != null) goto L19;
            r12.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (Build.VERSION.SDK_INT < 21) goto L45;
            if (this.mCapabilityBindingParams == null) goto L39;
            ShortcutInfoCompat r13 = this.mInfo;
            if (r13.mExtras != null) goto L27;
            r13.mExtras = new PersistableBundle();
        L27:
            Iterator<String> r14 = this.mCapabilityBindingParams.keySet().iterator();
        L29:
            if (r14.hasNext() == false) goto L39;
            String r15 = r14.next();
            Map<String, List<String>> r16 = this.mCapabilityBindingParams.get(r15);
            this.mInfo.mExtras.putStringArray(r15, (String[]) r16.keySet().toArray(new String[0]));
            Iterator<String> r17 = r16.keySet().iterator();
        L32:
            if (r17.hasNext() == false) goto L29;
            String r18 = r17.next();
            List<String> r19 = r16.get(r18);
            PersistableBundle r20 = this.mInfo.mExtras;
            String r21 = r15 + "/" + r18;
            if (r19 != null) goto L36;
            String[] r22 = new String[0];
        L37:
            r20.putStringArray(r21, r22);
            goto L32
        L36:
            r22 = (String[]) r19.toArray(new String[0]);
        L39:
            if (this.mSliceUri == null) goto L45;
            ShortcutInfoCompat r23 = this.mInfo;
            if (r23.mExtras != null) goto L43;
            r23.mExtras = new PersistableBundle();
        L43:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L45:
            return this.mInfo;
        L47:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L49:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName r10) {
            this.mInfo.mActivity = r10;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> r10) {
            this.mInfo.mCategories = r10;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence r10) {
            this.mInfo.mDisabledMessage = r10;
            return this;
        }

        @NonNull
        public Builder setExcludedFromSurfaces(int r10) {
            this.mInfo.mExcludedSurfaces = r10;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle r10) {
            this.mInfo.mExtras = r10;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat r10) {
            this.mInfo.mIcon = r10;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent r10) {
            return setIntents(new Intent[]{r10});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] r10) {
            this.mInfo.mIntents = r10;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r10) {
            this.mInfo.mLocusId = r10;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence r10) {
            this.mInfo.mLongLabel = r10;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean r10) {
            this.mInfo.mIsLongLived = r10;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person r10) {
            return setPersons(new Person[]{r10});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] r10) {
            this.mInfo.mPersons = r10;
            return this;
        }

        @NonNull
        public Builder setRank(int r10) {
            this.mInfo.mRank = r10;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence r10) {
            this.mInfo.mLabel = r10;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri r10) {
            this.mSliceUri = r10;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle r10) {
            ShortcutInfoCompat r11 = this.mInfo;
            r11.mTransientExtras = (Bundle) Preconditions.checkNotNull(r10);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Surface {
    }

    ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r10 = this.mPersons;
        if (r10 != null) goto L8;
    L13:
        LocusIdCompat r11 = this.mLocusId;
        if (r11 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r11.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r10.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r10.length);
        int r12 = 0;
    L11:
        if (r12 >= this.mPersons.length) goto L13;
        PersistableBundle r13 = this.mExtras;
        StringBuilder r14 = new StringBuilder();
        r14.append(EXTRA_PERSON_);
        int r15 = r12 + 1;
        r14.append(r15);
        r13.putPersistableBundle(r14.toString(), this.mPersons[r12].toPersistableBundle());
        r12 = r15;
        goto L11
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static List<ShortcutInfoCompat> fromShortcuts(@NonNull Context r10, @NonNull List<ShortcutInfo> r11) {
        ArrayList r12 = new ArrayList(r11.size());
        Iterator<ShortcutInfo> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(new Builder(r10, r13.next()).build());
        goto L4
    L6:
        return r12;
    }

    @Nullable
    @RequiresApi(25)
    static LocusIdCompat getLocusId(@NonNull ShortcutInfo r10) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r10.getLocusId() != null) goto L9;
        return null;
    L9:
        return LocusIdCompat.toLocusIdCompat(r10.getLocusId());
    L11:
        return getLocusIdFromExtra(r10.getExtras());
    }

    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = r10.getString(EXTRA_LOCUS_ID);
        if (r11 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r11);
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    static boolean getLongLivedFromExtra(@Nullable PersistableBundle r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (r10.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r10.getBoolean(EXTRA_LONG_LIVED);
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static Person[] getPersonsFromExtra(@NonNull PersistableBundle r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r11 = r10.getInt(EXTRA_PERSON_COUNT);
        Person[] r12 = new Person[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        StringBuilder r14 = new StringBuilder();
        r14.append(EXTRA_PERSON_);
        int r15 = r13 + 1;
        r14.append(r15);
        r12[r13] = Person.fromPersistableBundle(r10.getPersistableBundle(r14.toString()));
        r13 = r15;
        goto L7
    L9:
        return r12;
    L13:
        return null;
    }

    Intent addToIntent(Intent r10) {
        Intent[] r11 = this.mIntents;
        r10.putExtra("android.intent.extra.shortcut.INTENT", r11[r11.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L12;
        Drawable r12 = null;
        if (this.mIsAlwaysBadged == false) goto L11;
        PackageManager r13 = this.mContext.getPackageManager();
        ComponentName r14 = this.mActivity;
        if (r14 != null) goto L14;
    L9:
        if (r12 != null) goto L11;
        r12 = this.mContext.getApplicationInfo().loadIcon(r13);
        goto L11
    L14:
        r12 = r13.getActivityIcon(r14);     // Catch: PackageManager.NameNotFoundException -> L13
    L11:
        this.mIcon.addToShortcutIntent(r10, r12, this.mContext);
    L12:
        return r10;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.mCategories;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public Intent getIntent() {
        Intent[] r10 = this.mIntents;
        return r10[r10.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] r10 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r10, r10.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    @NonNull
    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int r10) {
        if ((this.mExcludedSurfaces & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder r10 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r11 = this.mIcon;
        if (r11 == null) goto L6;
        r10.setIcon(r11.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r10.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r10.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r12 = this.mActivity;
        if (r12 == null) goto L14;
        r10.setActivity(r12);
    L14:
        Set<String> r13 = this.mCategories;
        if (r13 == null) goto L17;
        r10.setCategories(r13);
    L17:
        r10.setRank(this.mRank);
        PersistableBundle r14 = this.mExtras;
        if (r14 == null) goto L21;
        r10.setExtras(r14);
    L21:
        if (Build.VERSION.SDK_INT < 29) goto L34;
        Person[] r15 = this.mPersons;
        if (r15 != null) goto L25;
    L30:
        LocusIdCompat r16 = this.mLocusId;
        if (r16 == null) goto L33;
        r10.setLocusId(r16.toLocusId());
    L33:
        r10.setLongLived(this.mIsLongLived);
    L36:
        if (Build.VERSION.SDK_INT < 33) goto L39;
        Api33Impl.setExcludedFromSurfaces(r10, this.mExcludedSurfaces);
    L39:
        return r10.build();
    L25:
        if (r15.length <= 0) goto L30;
        int r17 = r15.length;
        android.app.Person[] r18 = new android.app.Person[r17];
        int r19 = 0;
    L27:
        if (r19 >= r17) goto L29;
        r18[r19] = this.mPersons[r19].toAndroidPerson();
        r19 = r19 + 1;
        goto L27
    L29:
        r10.setPersons(r18);
        goto L30
    L34:
        r10.setExtras(buildLegacyExtrasBundle());
        goto L36
    }
}
