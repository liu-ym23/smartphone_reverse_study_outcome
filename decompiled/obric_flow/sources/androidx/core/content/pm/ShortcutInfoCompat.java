package androidx.core.content.pm;

import ai.j0;
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
import androidx.collection.ArraySet;
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
    public static class Api33Impl {
        private Api33Impl() {
        }

        public static void setExcludedFromSurfaces(@NonNull ShortcutInfo.Builder r5, int r10) {
            r5.setExcludedFromSurfaces(r10);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(@NonNull Context r5, @NonNull String r10) {
            ShortcutInfoCompat r11 = new ShortcutInfoCompat();
            this.mInfo = r11;
            r11.mContext = r5;
            r11.mId = r10;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r5) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r5);
            return this;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L47;
            ShortcutInfoCompat r5 = this.mInfo;
            Intent[] r10 = r5.mIntents;
            if (r10 == null) goto L45;
            if (r10.length == 0) goto L45;
            if (this.mIsConversation == false) goto L15;
            if (r5.mLocusId != null) goto L13;
            r5.mLocusId = new LocusIdCompat(r5.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            ShortcutInfoCompat r11 = this.mInfo;
            if (r11.mCategories != null) goto L19;
            r11.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (this.mCapabilityBindingParams == null) goto L37;
            ShortcutInfoCompat r12 = this.mInfo;
            if (r12.mExtras != null) goto L25;
            r12.mExtras = new PersistableBundle();
        L25:
            Iterator<String> r13 = this.mCapabilityBindingParams.keySet().iterator();
        L27:
            if (r13.hasNext() == false) goto L37;
            String r14 = r13.next();
            Map<String, List<String>> r15 = this.mCapabilityBindingParams.get(r14);
            Set<String> r16 = r15.keySet();
            this.mInfo.mExtras.putStringArray(r14, (String[]) r16.toArray(new String[0]));
            Iterator<String> r17 = r15.keySet().iterator();
        L30:
            if (r17.hasNext() == false) goto L27;
            String r18 = r17.next();
            List<String> r19 = r15.get(r18);
            PersistableBundle r20 = this.mInfo.mExtras;
            String r21 = j0.D(r14, "/", r18);
            if (r19 != null) goto L34;
            String[] r22 = new String[0];
        L35:
            r20.putStringArray(r21, r22);
            goto L30
        L34:
            r22 = (String[]) r19.toArray(new String[0]);
        L37:
            if (this.mSliceUri == null) goto L43;
            ShortcutInfoCompat r23 = this.mInfo;
            if (r23.mExtras != null) goto L41;
            r23.mExtras = new PersistableBundle();
        L41:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L43:
            return this.mInfo;
        L45:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L47:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName r5) {
            this.mInfo.mActivity = r5;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> r5) {
            ArraySet r10 = new ArraySet();
            r10.addAll(r5);
            this.mInfo.mCategories = r10;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence r5) {
            this.mInfo.mDisabledMessage = r5;
            return this;
        }

        @NonNull
        public Builder setExcludedFromSurfaces(int r5) {
            this.mInfo.mExcludedSurfaces = r5;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle r5) {
            this.mInfo.mExtras = r5;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat r5) {
            this.mInfo.mIcon = r5;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent r5) {
            return setIntents(new Intent[]{r5});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] r5) {
            this.mInfo.mIntents = r5;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r5) {
            this.mInfo.mLocusId = r5;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence r5) {
            this.mInfo.mLongLabel = r5;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person r5) {
            return setPersons(new Person[]{r5});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] r5) {
            this.mInfo.mPersons = r5;
            return this;
        }

        @NonNull
        public Builder setRank(int r5) {
            this.mInfo.mRank = r5;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence r5) {
            this.mInfo.mLabel = r5;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri r5) {
            this.mSliceUri = r5;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle r5) {
            ShortcutInfoCompat r10 = this.mInfo;
            r10.mTransientExtras = (Bundle) Preconditions.checkNotNull(r5);
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean r5) {
            this.mInfo.mIsLongLived = r5;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r5, @NonNull String r10, @NonNull List<String> r11) {
            addCapabilityBinding(r5);
            if (r11.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r5) != null) goto L10;
            this.mCapabilityBindingParams.put(r5, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r5).put(r10, r11);
            goto L11
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat r5) {
            ShortcutInfoCompat r10 = new ShortcutInfoCompat();
            this.mInfo = r10;
            r10.mContext = r5.mContext;
            r10.mId = r5.mId;
            r10.mPackageName = r5.mPackageName;
            Intent[] r11 = r5.mIntents;
            r10.mIntents = (Intent[]) Arrays.copyOf(r11, r11.length);
            r10.mActivity = r5.mActivity;
            r10.mLabel = r5.mLabel;
            r10.mLongLabel = r5.mLongLabel;
            r10.mDisabledMessage = r5.mDisabledMessage;
            r10.mDisabledReason = r5.mDisabledReason;
            r10.mIcon = r5.mIcon;
            r10.mIsAlwaysBadged = r5.mIsAlwaysBadged;
            r10.mUser = r5.mUser;
            r10.mLastChangedTimestamp = r5.mLastChangedTimestamp;
            r10.mIsCached = r5.mIsCached;
            r10.mIsDynamic = r5.mIsDynamic;
            r10.mIsPinned = r5.mIsPinned;
            r10.mIsDeclaredInManifest = r5.mIsDeclaredInManifest;
            r10.mIsImmutable = r5.mIsImmutable;
            r10.mIsEnabled = r5.mIsEnabled;
            r10.mLocusId = r5.mLocusId;
            r10.mIsLongLived = r5.mIsLongLived;
            r10.mHasKeyFieldsOnly = r5.mHasKeyFieldsOnly;
            r10.mRank = r5.mRank;
            Person[] r12 = r5.mPersons;
            if (r12 == null) goto L6;
            r10.mPersons = (Person[]) Arrays.copyOf(r12, r12.length);
        L6:
            if (r5.mCategories == null) goto L8;
            r10.mCategories = new HashSet(r5.mCategories);
        L8:
            PersistableBundle r13 = r5.mExtras;
            if (r13 == null) goto L11;
            r10.mExtras = r13;
        L11:
            r10.mExcludedSurfaces = r5.mExcludedSurfaces;
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context r5, @NonNull ShortcutInfo r10) {
            ShortcutInfoCompat r11 = new ShortcutInfoCompat();
            this.mInfo = r11;
            r11.mContext = r5;
            r11.mId = r10.getId();
            r11.mPackageName = r10.getPackage();
            Intent[] r12 = r10.getIntents();
            r11.mIntents = (Intent[]) Arrays.copyOf(r12, r12.length);
            r11.mActivity = r10.getActivity();
            r11.mLabel = r10.getShortLabel();
            r11.mLongLabel = r10.getLongLabel();
            r11.mDisabledMessage = r10.getDisabledMessage();
            r11.mDisabledReason = r10.getDisabledReason();
            r11.mCategories = r10.getCategories();
            r11.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r10.getExtras());
            r11.mUser = r10.getUserHandle();
            r11.mLastChangedTimestamp = r10.getLastChangedTimestamp();
            r11.mIsCached = r10.isCached();
            r11.mIsDynamic = r10.isDynamic();
            r11.mIsPinned = r10.isPinned();
            r11.mIsDeclaredInManifest = r10.isDeclaredInManifest();
            r11.mIsImmutable = r10.isImmutable();
            r11.mIsEnabled = r10.isEnabled();
            r11.mHasKeyFieldsOnly = r10.hasKeyFieldsOnly();
            r11.mLocusId = ShortcutInfoCompat.getLocusId(r10);
            r11.mRank = r10.getRank();
            r11.mExtras = r10.getExtras();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Surface {
    }

    public ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r5 = this.mPersons;
        if (r5 != null) goto L8;
    L13:
        LocusIdCompat r10 = this.mLocusId;
        if (r10 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r10.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r5.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r5.length);
        int r11 = 0;
    L11:
        if (r11 >= this.mPersons.length) goto L13;
        PersistableBundle r12 = this.mExtras;
        StringBuilder r13 = new StringBuilder(EXTRA_PERSON_);
        int r14 = r11 + 1;
        r13.append(r14);
        r12.putPersistableBundle(r13.toString(), this.mPersons[r11].toPersistableBundle());
        r11 = r14;
        goto L11
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static List<ShortcutInfoCompat> fromShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfo> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<ShortcutInfo> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(new Builder(r5, r12.next()).build());
        goto L4
    L6:
        return r11;
    }

    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r10 = r5.getString(EXTRA_LOCUS_ID);
        if (r10 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r10);
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static boolean getLongLivedFromExtra(@Nullable PersistableBundle r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r5.getBoolean(EXTRA_LONG_LIVED);
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person[] getPersonsFromExtra(@NonNull PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r10 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r11 = new Person[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        StringBuilder r13 = new StringBuilder(EXTRA_PERSON_);
        int r14 = r12 + 1;
        r13.append(r14);
        r11[r12] = Person.fromPersistableBundle(r5.getPersistableBundle(r13.toString()));
        r12 = r14;
        goto L7
    L9:
        return r11;
    L13:
        return null;
    }

    public Intent addToIntent(Intent r5) {
        Intent[] r10 = this.mIntents;
        r5.putExtra("android.intent.extra.shortcut.INTENT", r10[r10.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L12;
        Drawable r11 = null;
        if (this.mIsAlwaysBadged == false) goto L11;
        PackageManager r12 = this.mContext.getPackageManager();
        ComponentName r13 = this.mActivity;
        if (r13 != null) goto L14;
    L9:
        if (r11 != null) goto L11;
        r11 = this.mContext.getApplicationInfo().loadIcon(r12);
        goto L11
    L14:
        r11 = r12.getActivityIcon(r13);     // Catch: PackageManager.NameNotFoundException -> L13
    L11:
        this.mIcon.addToShortcutIntent(r5, r11, this.mContext);
    L12:
        return r5;
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
        Intent[] r5 = this.mIntents;
        return r5[r5.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] r5 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r5, r5.length);
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

    public boolean isExcludedFromSurfaces(int r5) {
        if ((this.mExcludedSurfaces & r5) == 0) goto L5;
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
        ShortcutInfo.Builder r5 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r10 = this.mIcon;
        if (r10 == null) goto L6;
        r5.setIcon(r10.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r5.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r5.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r11 = this.mActivity;
        if (r11 == null) goto L14;
        r5.setActivity(r11);
    L14:
        Set<String> r12 = this.mCategories;
        if (r12 == null) goto L17;
        r5.setCategories(r12);
    L17:
        r5.setRank(this.mRank);
        PersistableBundle r13 = this.mExtras;
        if (r13 == null) goto L20;
        r5.setExtras(r13);
    L20:
        Person[] r14 = this.mPersons;
        if (r14 != null) goto L23;
    L28:
        LocusIdCompat r15 = this.mLocusId;
        if (r15 == null) goto L31;
        r5.setLocusId(r15.toLocusId());
    L31:
        r5.setLongLived(this.mIsLongLived);
        if (Build.VERSION.SDK_INT < 33) goto L35;
        Api33Impl.setExcludedFromSurfaces(r5, this.mExcludedSurfaces);
    L35:
        return r5.build();
    L23:
        if (r14.length <= 0) goto L28;
        int r16 = r14.length;
        android.app.Person[] r17 = new android.app.Person[r16];
        int r18 = 0;
    L25:
        if (r18 >= r16) goto L27;
        r17[r18] = this.mPersons[r18].toAndroidPerson();
        r18 = r18 + 1;
        goto L25
    L27:
        r5.setPersons(r17);
        goto L28
    }

    @Nullable
    @RequiresApi(25)
    public static LocusIdCompat getLocusId(@NonNull ShortcutInfo r5) {
        if (r5.getLocusId() != null) goto L7;
        return null;
    L7:
        return LocusIdCompat.toLocusIdCompat(r5.getLocusId());
    }
}
