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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void setExcludedFromSurfaces(ShortcutInfo.Builder r0, int r1) {
            r0.setExcludedFromSurfaces(r1);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context r3, ShortcutInfo r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            r0.mId = r4.getId();
            r0.mPackageName = r4.getPackage();
            Intent[] r2 = r4.getIntents();
            r0.mIntents = (Intent[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Intent[].class, "com.obric.memorydata.plugin");
            r0.mActivity = r4.getActivity();
            r0.mLabel = r4.getShortLabel();
            r0.mLongLabel = r4.getLongLabel();
            r0.mDisabledMessage = r4.getDisabledMessage();
            if (Build.VERSION.SDK_INT < 28) goto L7;
            int r6 = r4.getDisabledReason();
        L5:
            r0.mDisabledReason = r6;
            r0.mCategories = r4.getCategories();
            r0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r4.getExtras());
            r0.mUser = r4.getUserHandle();
            r0.mLastChangedTimestamp = r4.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT < 30) goto L13;
            r0.mIsCached = r4.isCached();
        L13:
            r0.mIsDynamic = r4.isDynamic();
            r0.mIsPinned = r4.isPinned();
            r0.mIsDeclaredInManifest = r4.isDeclaredInManifest();
            r0.mIsImmutable = r4.isImmutable();
            r0.mIsEnabled = r4.isEnabled();
            r0.mHasKeyFieldsOnly = r4.hasKeyFieldsOnly();
            r0.mLocusId = ShortcutInfoCompat.getLocusId(r4);
            r0.mRank = r4.getRank();
            r0.mExtras = r4.getExtras();
            return;
        L7:
            if (r4.isEnabled() == false) goto L9;
            r6 = 0;
            goto L5
        L9:
            r6 = 3;
            goto L5
        }

        public Builder(Context r3, String r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            r0.mId = r4;
        }

        public Builder(ShortcutInfoCompat r5) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = ZeusTransformUtils.wrapperContext(r5.mContext, "com.obric.memorydata.plugin");
            r0.mId = r5.mId;
            r0.mPackageName = r5.mPackageName;
            r0.mIntents = (Intent[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5.mIntents, r5.mIntents.length), Intent[].class, "com.obric.memorydata.plugin");
            r0.mActivity = r5.mActivity;
            r0.mLabel = r5.mLabel;
            r0.mLongLabel = r5.mLongLabel;
            r0.mDisabledMessage = r5.mDisabledMessage;
            r0.mDisabledReason = r5.mDisabledReason;
            r0.mIcon = r5.mIcon;
            r0.mIsAlwaysBadged = r5.mIsAlwaysBadged;
            r0.mUser = r5.mUser;
            r0.mLastChangedTimestamp = r5.mLastChangedTimestamp;
            r0.mIsCached = r5.mIsCached;
            r0.mIsDynamic = r5.mIsDynamic;
            r0.mIsPinned = r5.mIsPinned;
            r0.mIsDeclaredInManifest = r5.mIsDeclaredInManifest;
            r0.mIsImmutable = r5.mIsImmutable;
            r0.mIsEnabled = r5.mIsEnabled;
            r0.mLocusId = r5.mLocusId;
            r0.mIsLongLived = r5.mIsLongLived;
            r0.mHasKeyFieldsOnly = r5.mHasKeyFieldsOnly;
            r0.mRank = r5.mRank;
            if (r5.mPersons == null) goto L6;
            r0.mPersons = (Person[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5.mPersons, r5.mPersons.length), Person[].class, "com.obric.memorydata.plugin");
        L6:
            if (r5.mCategories == null) goto L9;
            r0.mCategories = new HashSet(r5.mCategories);
        L9:
            if (r5.mExtras == null) goto L11;
            r0.mExtras = r5.mExtras;
        L11:
            r0.mExcludedSurfaces = r5.mExcludedSurfaces;
        }

        public Builder addCapabilityBinding(String r2) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r2);
            return this;
        }

        public Builder addCapabilityBinding(String r4, String r5, List<String> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            addCapabilityBinding(r4);
            if (r7.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r4) != null) goto L10;
            this.mCapabilityBindingParams.put(r4, new HashMap());
        L10:
            ((Map) ZeusTransformUtils.preCheckCast(this.mCapabilityBindingParams.get(r4), Map.class, "com.obric.memorydata.plugin")).put(r5, r7);
            goto L11
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L49;
            if (this.mInfo.mIntents == null) goto L47;
            if (this.mInfo.mIntents.length == 0) goto L47;
            if (this.mIsConversation == false) goto L15;
            if (this.mInfo.mLocusId != null) goto L13;
            this.mInfo.mLocusId = new LocusIdCompat(this.mInfo.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            if (this.mInfo.mCategories != null) goto L19;
            this.mInfo.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (Build.VERSION.SDK_INT < 21) goto L45;
            if (this.mCapabilityBindingParams == null) goto L39;
            if (this.mInfo.mExtras != null) goto L27;
            this.mInfo.mExtras = new PersistableBundle();
        L27:
            Iterator<String> r0 = this.mCapabilityBindingParams.keySet().iterator();
        L29:
            if (r0.hasNext() == false) goto L39;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
            Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.mCapabilityBindingParams.get(r1), Map.class, "com.obric.memorydata.plugin");
            this.mInfo.mExtras.putStringArray(r1, (String[]) ZeusTransformUtils.preCheckCast(r2.keySet().toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
            Iterator r4 = r2.keySet().iterator();
        L32:
            if (r4.hasNext() == false) goto L29;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.preCheckCast(r2.get(r5), List.class, "com.obric.memorydata.plugin");
            PersistableBundle r8 = this.mInfo.mExtras;
            String r6 = r1 + "/" + r5;
            if (r7 != null) goto L36;
            String[] r9 = new String[0];
        L37:
            r8.putStringArray(r6, r9);
            goto L32
        L36:
            r9 = (String[]) ZeusTransformUtils.preCheckCast(r7.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        L39:
            if (this.mSliceUri == null) goto L45;
            if (this.mInfo.mExtras != null) goto L43;
            this.mInfo.mExtras = new PersistableBundle();
        L43:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L45:
            return this.mInfo;
        L47:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L49:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        public Builder setActivity(ComponentName r2) {
            this.mInfo.mActivity = r2;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setCategories(Set<String> r3) {
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            ArraySet r0 = new ArraySet();
            r0.addAll(r4);
            this.mInfo.mCategories = r0;
            return this;
        }

        public Builder setDisabledMessage(CharSequence r3) {
            this.mInfo.mDisabledMessage = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
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

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r2) {
            this.mInfo.mLocusId = r2;
            return this;
        }

        public Builder setLongLabel(CharSequence r3) {
            this.mInfo.mLongLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
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

        public Builder setShortLabel(CharSequence r3) {
            this.mInfo.mLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setSliceUri(Uri r1) {
            this.mSliceUri = r1;
            return this;
        }

        public Builder setTransientExtras(Bundle r4) {
            ShortcutInfoCompat r0 = this.mInfo;
            r0.mTransientExtras = (Bundle) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4), Bundle.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    ShortcutInfoCompat() {
        this.mIsEnabled = true;
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
        int r3 = r2 + 1;
        this.mExtras.putPersistableBundle(EXTRA_PERSON_ + r3, this.mPersons[r2].toPersistableBundle());
        r2 = r3;
        goto L11
    }

    static List<ShortcutInfoCompat> fromShortcuts(Context r4, List<ShortcutInfo> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r7.size());
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(new Builder(r6, (ShortcutInfo) ZeusTransformUtils.preCheckCast(r8.next(), ShortcutInfo.class, "com.obric.memorydata.plugin")).build());
        goto L4
    L6:
        return r0;
    }

    static LocusIdCompat getLocusId(ShortcutInfo r2) {
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

    static boolean getLongLivedFromExtra(PersistableBundle r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r2.getBoolean(EXTRA_LONG_LIVED);
    }

    static Person[] getPersonsFromExtra(PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r0 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r1 = new Person[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r4 = r2 + 1;
        r1[r2] = Person.fromPersistableBundle(r5.getPersistableBundle(EXTRA_PERSON_ + r4));
        r2 = r4;
        goto L7
    L9:
        return r1;
    L13:
        return null;
    }

    Intent addToIntent(Intent r4) {
        Intent[] r0 = this.mIntents;
        r4.putExtra("android.intent.extra.shortcut.INTENT", r0[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L12;
        Drawable r1 = null;
        if (this.mIsAlwaysBadged == false) goto L11;
        PackageManager r2 = this.mContext.getPackageManager();
        ComponentName r3 = this.mActivity;
        if (r3 != null) goto L14;
    L9:
        if (r1 != null) goto L11;
        r1 = this.mContext.getApplicationInfo().loadIcon(r2);
        goto L11
    L14:
        r1 = r2.getActivityIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L13
    L11:
        this.mIcon.addToShortcutIntent(r4, r1, this.mContext);
    L12:
        return r4;
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

    public Intent getIntent() {
        Intent[] r1 = this.mIntents;
        return r1[r1.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] r2 = this.mIntents;
        return (Intent[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Intent[].class, "com.obric.memorydata.plugin");
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

    public boolean isExcludedFromSurfaces(int r1) {
        if ((this.mExcludedSurfaces & r1) == 0) goto L5;
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
}
