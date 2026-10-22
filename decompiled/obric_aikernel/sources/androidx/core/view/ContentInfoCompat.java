package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;

    @NonNull
    private final Compat mCompat;

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @NonNull
        @DoNotInline
        public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r10, @NonNull final Predicate<ClipData.Item> r11) {
            ClipData r12 = r10.getClip();
            if (r12.getItemCount() != 1) goto L12;
            boolean r13 = r11.test(r12.getItemAt(0));
            if (r13 == false) goto L7;
            ContentInfo r14 = r10;
        L8:
            if (r13 == false) goto L11;
            r10 = null;
        L11:
            return Pair.create(r14, r10);
        L7:
            r14 = null;
            goto L8
        L12:
            Objects.requireNonNull(r11);
            Pair<ClipData, ClipData> r15 = ContentInfoCompat.partition(r12, new a(r11));
            if (r15.first != null) goto L17;
            return Pair.create(null, r10);
        L17:
            if (r15.second != null) goto L21;
            return Pair.create(r10, null);
        L21:
            return Pair.create(new ContentInfo.Builder(r10).setClip((ClipData) r15.first).build(), new ContentInfo.Builder(r10).setClip((ClipData) r15.second).build());
        }
    }

    public static final class Builder {

        @NonNull
        private final BuilderCompat mBuilderCompat;

        public Builder(@NonNull ClipData r10, int r11) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            BuilderCompat r12 = new BuilderCompat31Impl(r10, r11);
        L6:
            this.mBuilderCompat = r12;
            return;
        L5:
            r12 = new BuilderCompatImpl(r10, r11);
            goto L6
        }

        public Builder(@NonNull ContentInfoCompat r10) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            BuilderCompat r11 = new BuilderCompat31Impl(r10);
        L6:
            this.mBuilderCompat = r11;
            return;
        L5:
            r11 = new BuilderCompatImpl(r10);
            goto L6
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData r10) {
            this.mBuilderCompat.setClip(r10);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r10) {
            this.mBuilderCompat.setExtras(r10);
            return this;
        }

        @NonNull
        public Builder setFlags(int r10) {
            this.mBuilderCompat.setFlags(r10);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri r10) {
            this.mBuilderCompat.setLinkUri(r10);
            return this;
        }

        @NonNull
        public Builder setSource(int r10) {
            this.mBuilderCompat.setSource(r10);
            return this;
        }
    }

    private interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData r10);

        void setExtras(@Nullable Bundle r10);

        void setFlags(int r10);

        void setLinkUri(@Nullable Uri r10);

        void setSource(int r10);
    }

    @RequiresApi(31)
    private static final class BuilderCompat31Impl implements BuilderCompat {

        @NonNull
        private final ContentInfo.Builder mPlatformBuilder;

        BuilderCompat31Impl(@NonNull ClipData r10, int r11) {
            this.mPlatformBuilder = new ContentInfo.Builder(r10, r11);
        }

        BuilderCompat31Impl(@NonNull ContentInfoCompat r10) {
            this.mPlatformBuilder = new ContentInfo.Builder(r10.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r10) {
            this.mPlatformBuilder.setClip(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r10) {
            this.mPlatformBuilder.setExtras(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r10) {
            this.mPlatformBuilder.setFlags(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r10) {
            this.mPlatformBuilder.setLinkUri(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r10) {
            this.mPlatformBuilder.setSource(r10);
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {

        @NonNull
        ClipData mClip;

        @Nullable
        Bundle mExtras;
        int mFlags;

        @Nullable
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(@NonNull ClipData r10, int r11) {
            this.mClip = r10;
            this.mSource = r11;
        }

        BuilderCompatImpl(@NonNull ContentInfoCompat r10) {
            this.mClip = r10.getClip();
            this.mSource = r10.getSource();
            this.mFlags = r10.getFlags();
            this.mLinkUri = r10.getLinkUri();
            this.mExtras = r10.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r10) {
            this.mClip = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r10) {
            this.mExtras = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r10) {
            this.mFlags = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r10) {
            this.mLinkUri = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r10) {
            this.mSource = r10;
        }
    }

    private interface Compat {
        @NonNull
        ClipData getClip();

        @Nullable
        Bundle getExtras();

        int getFlags();

        @Nullable
        Uri getLinkUri();

        int getSource();

        @Nullable
        ContentInfo getWrapped();
    }

    @RequiresApi(31)
    private static final class Compat31Impl implements Compat {

        @NonNull
        private final ContentInfo mWrapped;

        Compat31Impl(@NonNull ContentInfo r10) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mWrapped.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    private static final class CompatImpl implements Compat {

        @NonNull
        private final ClipData mClip;

        @Nullable
        private final Bundle mExtras;
        private final int mFlags;

        @Nullable
        private final Uri mLinkUri;
        private final int mSource;

        CompatImpl(BuilderCompatImpl r10) {
            this.mClip = (ClipData) Preconditions.checkNotNull(r10.mClip);
            this.mSource = Preconditions.checkArgumentInRange(r10.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(r10.mFlags, 1);
            this.mLinkUri = r10.mLinkUri;
            this.mExtras = r10.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public ContentInfo getWrapped() {
            return null;
        }

        @NonNull
        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("ContentInfoCompat{clip=");
            r10.append(this.mClip.getDescription());
            r10.append(", source=");
            r10.append(ContentInfoCompat.sourceToString(this.mSource));
            r10.append(", flags=");
            r10.append(ContentInfoCompat.flagsToString(this.mFlags));
            String r11 = "";
            if (this.mLinkUri != null) goto L5;
            String r12 = "";
        L6:
            r10.append(r12);
            if (this.mExtras == null) goto L10;
            r11 = ", hasExtras";
        L10:
            r10.append(r11);
            r10.append("}");
            return r10.toString();
        L5:
            r12 = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    ContentInfoCompat(@NonNull Compat r10) {
        this.mCompat = r10;
    }

    @NonNull
    static ClipData buildClipData(@NonNull ClipDescription r10, @NonNull List<ClipData.Item> r11) {
        ClipData r12 = new ClipData(new ClipDescription(r10), r11.get(0));
        int r13 = 1;
    L4:
        if (r13 >= r11.size()) goto L6;
        r12.addItem(r11.get(r13));
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String flagsToString(int r10) {
        if ((r10 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r10);
    }

    @NonNull
    static Pair<ClipData, ClipData> partition(@NonNull ClipData r10, @NonNull androidx.core.util.Predicate<ClipData.Item> r11) {
        int r12 = 0;
        ArrayList r13 = null;
        ArrayList r14 = null;
    L4:
        if (r12 >= r10.getItemCount()) goto L14;
        ClipData.Item r15 = r10.getItemAt(r12);
        if (r11.test(r15) == false) goto L10;
        if (r13 != null) goto L9;
        r13 = new ArrayList();
    L9:
        r13.add(r15);
    L13:
        r12 = r12 + 1;
        goto L4
    L10:
        if (r14 != null) goto L12;
        r14 = new ArrayList();
    L12:
        r14.add(r15);
        goto L13
    L14:
        if (r13 == null) goto L16;
        if (r14 != null) goto L21;
        return Pair.create(r10, null);
    L21:
        return Pair.create(buildClipData(r10.getDescription(), r13), buildClipData(r10.getDescription(), r14));
    L16:
        return Pair.create(null, r10);
    }

    @NonNull
    @RequiresApi(31)
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r10, @NonNull Predicate<ClipData.Item> r11) {
        return Api31Impl.partition(r10, r11);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String sourceToString(int r10) {
        if (r10 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r10 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r10 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r10 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r10 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r10 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r10);
    }

    @NonNull
    @RequiresApi(31)
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo r10) {
        return new ContentInfoCompat(new Compat31Impl(r10));
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.Predicate<ClipData.Item> r10) {
        ClipData r11 = this.mCompat.getClip();
        if (r11.getItemCount() != 1) goto L12;
        boolean r12 = r10.test(r11.getItemAt(0));
        if (r12 == false) goto L7;
        ContentInfoCompat r13 = this;
    L8:
        if (r12 == false) goto L11;
        ContentInfoCompat this = null;
    L11:
        return Pair.create(r13, this);
    L7:
        r13 = null;
        goto L8
    L12:
        Pair<ClipData, ClipData> r14 = partition(r11, r10);
        if (r14.first != null) goto L17;
        return Pair.create(null, this);
    L17:
        if (r14.second != null) goto L21;
        return Pair.create(this, null);
    L21:
        return Pair.create(new Builder(this).setClip((ClipData) r14.first).build(), new Builder(this).setClip((ClipData) r14.second).build());
    }

    @NonNull
    @RequiresApi(31)
    public ContentInfo toContentInfo() {
        ContentInfo r10 = this.mCompat.getWrapped();
        Objects.requireNonNull(r10);
        return r10;
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }
}
