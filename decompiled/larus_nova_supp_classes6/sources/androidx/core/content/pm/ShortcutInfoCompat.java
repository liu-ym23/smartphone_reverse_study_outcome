package androidx.core.content.pm;

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
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static void setExcludedFromSurfaces(ShortcutInfo.Builder r0, int r1) {
            r0.setExcludedFromSurfaces(r1);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L47;
            ShortcutInfoCompat r0 = this.mInfo;
            Intent[] r1 = r0.mIntents;
            if (r1 == null) goto L45;
            if (r1.length == 0) goto L45;
            if (this.mIsConversation == false) goto L15;
            if (r0.mLocusId != null) goto L13;
            r0.mLocusId = new LocusIdCompat(r0.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            ShortcutInfoCompat r2 = this.mInfo;
            if (r2.mCategories != null) goto L19;
            r2.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (this.mCapabilityBindingParams == null) goto L37;
            ShortcutInfoCompat r3 = this.mInfo;
            if (r3.mExtras != null) goto L25;
            r3.mExtras = new PersistableBundle();
        L25:
            Iterator<String> r4 = this.mCapabilityBindingParams.keySet().iterator();
        L27:
            if (r4.hasNext() == false) goto L37;
            String r5 = r4.next();
            Map<String, List<String>> r6 = this.mCapabilityBindingParams.get(r5);
            this.mInfo.mExtras.putStringArray(r5, (String[]) r6.keySet().toArray(new String[0]));
            Iterator<String> r7 = r6.keySet().iterator();
        L30:
            if (r7.hasNext() == false) goto L27;
            String r8 = r7.next();
            List<String> r9 = r6.get(r8);
            PersistableBundle r10 = this.mInfo.mExtras;
            String r11 = r5 + "/" + r8;
            if (r9 != null) goto L34;
            String[] r12 = new String[0];
        L35:
            r10.putStringArray(r11, r12);
            goto L30
        L34:
            r12 = (String[]) r9.toArray(new String[0]);
        L37:
            if (this.mSliceUri == null) goto L43;
            ShortcutInfoCompat r13 = this.mInfo;
            if (r13.mExtras != null) goto L41;
            r13.mExtras = new PersistableBundle();
        L41:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L43:
            return this.mInfo;
        L45:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L47:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder(ShortcutInfoCompat r4) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r4.mContext;
            r0.mId = r4.mId;
            r0.mPackageName = r4.mPackageName;
            Intent[] r1 = r4.mIntents;
            r0.mIntents = (Intent[]) Arrays.copyOf(r1, r1.length);
            r0.mActivity = r4.mActivity;
            r0.mLabel = r4.mLabel;
            r0.mLongLabel = r4.mLongLabel;
            r0.mDisabledMessage = r4.mDisabledMessage;
            r0.mDisabledReason = r4.mDisabledReason;
            r0.mIcon = r4.mIcon;
            r0.mIsAlwaysBadged = r4.mIsAlwaysBadged;
            r0.mUser = r4.mUser;
            r0.mLastChangedTimestamp = r4.mLastChangedTimestamp;
            r0.mIsCached = r4.mIsCached;
            r0.mIsDynamic = r4.mIsDynamic;
            r0.mIsPinned = r4.mIsPinned;
            r0.mIsDeclaredInManifest = r4.mIsDeclaredInManifest;
            r0.mIsImmutable = r4.mIsImmutable;
            r0.mIsEnabled = r4.mIsEnabled;
            r0.mLocusId = r4.mLocusId;
            r0.mIsLongLived = r4.mIsLongLived;
            r0.mHasKeyFieldsOnly = r4.mHasKeyFieldsOnly;
            r0.mRank = r4.mRank;
            Person[] r2 = r4.mPersons;
            if (r2 == null) goto L6;
            r0.mPersons = (Person[]) Arrays.copyOf(r2, r2.length);
        L6:
            if (r4.mCategories == null) goto L8;
            r0.mCategories = new HashSet(r4.mCategories);
        L8:
            PersistableBundle r3 = r4.mExtras;
            if (r3 == null) goto L11;
            r0.mExtras = r3;
        L11:
            r0.mExcludedSurfaces = r4.mExcludedSurfaces;
        }

        public Builder addCapabilityBinding(String r2) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r2);
            return this;
        }

        public Builder setActivity(ComponentName r2) {
            this.mInfo.mActivity = r2;
            return this;
        }

        public Builder setCategories(Set<String> r2) {
            ArraySet r0 = new ArraySet();
            r0.addAll(r2);
            this.mInfo.mCategories = r0;
            return this;
        }

        public Builder setDisabledMessage(CharSequence r2) {
            this.mInfo.mDisabledMessage = r2;
            return this;
        }

        public Builder setExcludedFromSurfaces(int r2) {
            this.mInfo.mExcludedSurfaces = r2;
            return this;
        }

        public Builder setExtras(PersistableBundle r2) {
            this.mInfo.mExtras = r2;
            return this;
        }

        public Builder setIcon(IconCompat r2) {
            this.mInfo.mIcon = r2;
            return this;
        }

        public Builder setIntent(Intent r3) {
            return setIntents(new Intent[]{r3});
        }

        public Builder setIntents(Intent[] r2) {
            this.mInfo.mIntents = r2;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r2) {
            this.mInfo.mLocusId = r2;
            return this;
        }

        public Builder setLongLabel(CharSequence r2) {
            this.mInfo.mLongLabel = r2;
            return this;
        }

        public Builder setLongLived(boolean r2) {
            this.mInfo.mIsLongLived = r2;
            return this;
        }

        public Builder setPerson(Person r3) {
            return setPersons(new Person[]{r3});
        }

        public Builder setPersons(Person[] r2) {
            this.mInfo.mPersons = r2;
            return this;
        }

        public Builder setRank(int r2) {
            this.mInfo.mRank = r2;
            return this;
        }

        public Builder setShortLabel(CharSequence r2) {
            this.mInfo.mLabel = r2;
            return this;
        }

        public Builder setSliceUri(Uri r1) {
            this.mSliceUri = r1;
            return this;
        }

        public Builder setTransientExtras(Bundle r2) {
            ShortcutInfoCompat r0 = this.mInfo;
            r0.mTransientExtras = (Bundle) Preconditions.checkNotNull(r2);
            return this;
        }

        public Builder(Context r4, ShortcutInfo r5) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r4;
            r0.mId = r5.getId();
            r0.mPackageName = r5.getPackage();
            Intent[] r6 = r5.getIntents();
            r0.mIntents = (Intent[]) Arrays.copyOf(r6, r6.length);
            r0.mActivity = r5.getActivity();
            r0.mLabel = r5.getShortLabel();
            r0.mLongLabel = r5.getLongLabel();
            r0.mDisabledMessage = r5.getDisabledMessage();
            int r7 = Build.VERSION.SDK_INT;
            if (r7 < 28) goto L6;
            r0.mDisabledReason = r5.getDisabledReason();
        L10:
            r0.mCategories = r5.getCategories();
            r0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r5.getExtras());
            r0.mUser = r5.getUserHandle();
            r0.mLastChangedTimestamp = r5.getLastChangedTimestamp();
            if (r7 < 30) goto L13;
            r0.mIsCached = r5.isCached();
        L13:
            r0.mIsDynamic = r5.isDynamic();
            r0.mIsPinned = r5.isPinned();
            r0.mIsDeclaredInManifest = r5.isDeclaredInManifest();
            r0.mIsImmutable = r5.isImmutable();
            r0.mIsEnabled = r5.isEnabled();
            r0.mHasKeyFieldsOnly = r5.hasKeyFieldsOnly();
            r0.mLocusId = ShortcutInfoCompat.getLocusId(r5);
            r0.mRank = r5.getRank();
            r0.mExtras = r5.getExtras();
            return;
        L6:
            if (r5.isEnabled() == false) goto L8;
            int r1 = 0;
        L9:
            r0.mDisabledReason = r1;
            goto L10
        L8:
            r1 = 3;
            goto L9
        }

        public Builder(Context r2, String r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3;
        }

        public Builder addCapabilityBinding(String r3, String r4, List<String> r5) {
            addCapabilityBinding(r3);
            if (r5.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r3) != null) goto L10;
            this.mCapabilityBindingParams.put(r3, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r3).put(r4, r5);
            goto L11
        }
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r0 = this.mPersons;
        if (r0 != null) goto L8;
    L13:
        LocusIdCompat r1 = this.mLocusId;
        if (r1 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r1.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r0.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r0.length);
        int r2 = 0;
    L11:
        if (r2 >= this.mPersons.length) goto L13;
        PersistableBundle r3 = this.mExtras;
        StringBuilder r4 = new StringBuilder(EXTRA_PERSON_);
        int r5 = r2 + 1;
        r4.append(r5);
        r3.putPersistableBundle(r4.toString(), this.mPersons[r2].toPersistableBundle());
        r2 = r5;
        goto L11
    }

    public Intent getIntent() {
        Intent[] r0 = this.mIntents;
        return r0[r0.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] r0 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r0, r0.length);
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder r0 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r1 = this.mIcon;
        if (r1 == null) goto L6;
        r0.setIcon(r1.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r0.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r0.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r2 = this.mActivity;
        if (r2 == null) goto L14;
        r0.setActivity(r2);
    L14:
        Set<String> r3 = this.mCategories;
        if (r3 == null) goto L17;
        r0.setCategories(r3);
    L17:
        r0.setRank(this.mRank);
        PersistableBundle r4 = this.mExtras;
        if (r4 == null) goto L21;
        r0.setExtras(r4);
    L21:
        if (Build.VERSION.SDK_INT < 29) goto L34;
        Person[] r5 = this.mPersons;
        if (r5 != null) goto L25;
    L30:
        LocusIdCompat r6 = this.mLocusId;
        if (r6 == null) goto L33;
        r0.setLocusId(r6.toLocusId());
    L33:
        r0.setLongLived(this.mIsLongLived);
    L36:
        if (Build.VERSION.SDK_INT < 33) goto L39;
        Api33Impl.setExcludedFromSurfaces(r0, this.mExcludedSurfaces);
    L39:
        return r0.build();
    L25:
        if (r5.length <= 0) goto L30;
        int r7 = r5.length;
        android.app.Person[] r8 = new android.app.Person[r7];
        int r9 = 0;
    L27:
        if (r9 >= r7) goto L29;
        r8[r9] = this.mPersons[r9].toAndroidPerson();
        r9 = r9 + 1;
        goto L27
    L29:
        r0.setPersons(r8);
        goto L30
    L34:
        r0.setExtras(buildLegacyExtrasBundle());
        goto L36
    }

    public ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

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

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public static LocusIdCompat getLocusId(ShortcutInfo r2) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r2.getLocusId() != null) goto L9;
        return null;
    L9:
        return LocusIdCompat.toLocusIdCompat(r2.getLocusId());
    L11:
        return getLocusIdFromExtra(r2.getExtras());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.getString(EXTRA_LOCUS_ID);
        if (r3 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r3);
    }

    public static boolean getLongLivedFromExtra(PersistableBundle r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r2.getBoolean(EXTRA_LONG_LIVED);
    }

    public static Person[] getPersonsFromExtra(PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r0 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r1 = new Person[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        StringBuilder r3 = new StringBuilder(EXTRA_PERSON_);
        int r4 = r2 + 1;
        r3.append(r4);
        r1[r2] = Person.fromPersistableBundle(r5.getPersistableBundle(r3.toString()));
        r2 = r4;
        goto L7
    L9:
        return r1;
    L13:
        return null;
    }

    public Intent addToIntent(Intent r4) {
        Intent[] r0 = this.mIntents;
        r4.putExtra("android.intent.extra.shortcut.INTENT", r0[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L14;
        Drawable r1 = null;
        if (this.mIsAlwaysBadged == false) goto L13;
        PackageManager r2 = this.mContext.getPackageManager();
        ComponentName r3 = this.mActivity;
        if (r3 != null) goto L15;
    L11:
        if (r1 != null) goto L13;
        r1 = this.mContext.getApplicationInfo().loadIcon(r2);
        goto L13
    L15:
        r1 = r2.getActivityIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L10
    L13:
        this.mIcon.addToShortcutIntent(r4, r1, this.mContext);
    L14:
        return r4;
    }

    public boolean isExcludedFromSurfaces(int r2) {
        if ((r2 & this.mExcludedSurfaces) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<ShortcutInfoCompat> fromShortcuts(Context r3, List<ShortcutInfo> r4) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<ShortcutInfo> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(new Builder(r3, r5.next()).build());
        goto L4
    L6:
        return r0;
    }
}
