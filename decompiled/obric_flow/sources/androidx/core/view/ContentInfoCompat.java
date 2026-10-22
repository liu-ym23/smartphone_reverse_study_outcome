package androidx.core.view;

import ai.j0;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
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
    public static final class Api31Impl {
        private Api31Impl() {
        }

        @NonNull
        @DoNotInline
        public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r5, @NonNull final Predicate<ClipData.Item> r10) {
            ClipData r11 = r5.getClip();
            if (r11.getItemCount() != 1) goto L12;
            boolean r12 = r10.test(r11.getItemAt(0));
            if (r12 == false) goto L7;
            ContentInfo r13 = r5;
        L8:
            if (r12 == false) goto L11;
            r5 = null;
        L11:
            return Pair.create(r13, r5);
        L7:
            r13 = null;
            goto L8
        L12:
            Objects.requireNonNull(r10);
            Pair<ClipData, ClipData> r14 = ContentInfoCompat.partition(r11, new a(r10));
            if (r14.first != null) goto L17;
            return Pair.create(null, r5);
        L17:
            if (r14.second != null) goto L21;
            return Pair.create(r5, null);
        L21:
            return Pair.create(new ContentInfo.Builder(r5).setClip((ClipData) r14.first).build(), new ContentInfo.Builder(r5).setClip((ClipData) r14.second).build());
        }
    }

    public static final class Builder {

        @NonNull
        private final BuilderCompat mBuilderCompat;

        public Builder(@NonNull ContentInfoCompat r5) {
            this.mBuilderCompat = new BuilderCompat31Impl(r5);
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData r5) {
            this.mBuilderCompat.setClip(r5);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r5) {
            this.mBuilderCompat.setExtras(r5);
            return this;
        }

        @NonNull
        public Builder setFlags(int r5) {
            this.mBuilderCompat.setFlags(r5);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri r5) {
            this.mBuilderCompat.setLinkUri(r5);
            return this;
        }

        @NonNull
        public Builder setSource(int r5) {
            this.mBuilderCompat.setSource(r5);
            return this;
        }

        public Builder(@NonNull ClipData r5, int r10) {
            this.mBuilderCompat = new BuilderCompat31Impl(r5, r10);
        }
    }

    public interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData r5);

        void setExtras(@Nullable Bundle r5);

        void setFlags(int r5);

        void setLinkUri(@Nullable Uri r5);

        void setSource(int r5);
    }

    @RequiresApi(31)
    public static final class BuilderCompat31Impl implements BuilderCompat {

        @NonNull
        private final ContentInfo.Builder mPlatformBuilder;

        public BuilderCompat31Impl(@NonNull ClipData r5, int r10) {
            this.mPlatformBuilder = new ContentInfo.Builder(r5, r10);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r5) {
            this.mPlatformBuilder.setClip(r5);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r5) {
            this.mPlatformBuilder.setExtras(r5);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r5) {
            this.mPlatformBuilder.setFlags(r5);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r5) {
            this.mPlatformBuilder.setLinkUri(r5);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r5) {
            this.mPlatformBuilder.setSource(r5);
        }

        public BuilderCompat31Impl(@NonNull ContentInfoCompat r5) {
            this.mPlatformBuilder = new ContentInfo.Builder(r5.toContentInfo());
        }
    }

    public static final class BuilderCompatImpl implements BuilderCompat {

        @NonNull
        ClipData mClip;

        @Nullable
        Bundle mExtras;
        int mFlags;

        @Nullable
        Uri mLinkUri;
        int mSource;

        public BuilderCompatImpl(@NonNull ClipData r5, int r10) {
            this.mClip = r5;
            this.mSource = r10;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r5) {
            this.mClip = r5;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r5) {
            this.mExtras = r5;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r5) {
            this.mFlags = r5;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r5) {
            this.mLinkUri = r5;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r5) {
            this.mSource = r5;
        }

        public BuilderCompatImpl(@NonNull ContentInfoCompat r5) {
            this.mClip = r5.getClip();
            this.mSource = r5.getSource();
            this.mFlags = r5.getFlags();
            this.mLinkUri = r5.getLinkUri();
            this.mExtras = r5.getExtras();
        }
    }

    public interface Compat {
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
    public static final class Compat31Impl implements Compat {

        @NonNull
        private final ContentInfo mWrapped;

        public Compat31Impl(@NonNull ContentInfo r5) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(r5);
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

    public static final class CompatImpl implements Compat {

        @NonNull
        private final ClipData mClip;

        @Nullable
        private final Bundle mExtras;
        private final int mFlags;

        @Nullable
        private final Uri mLinkUri;
        private final int mSource;

        public CompatImpl(BuilderCompatImpl r5) {
            this.mClip = (ClipData) Preconditions.checkNotNull(r5.mClip);
            this.mSource = Preconditions.checkArgumentInRange(r5.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(r5.mFlags, 1);
            this.mLinkUri = r5.mLinkUri;
            this.mExtras = r5.mExtras;
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
            StringBuilder r5 = new StringBuilder("ContentInfoCompat{clip=");
            r5.append(this.mClip.getDescription());
            r5.append(", source=");
            r5.append(ContentInfoCompat.sourceToString(this.mSource));
            r5.append(", flags=");
            r5.append(ContentInfoCompat.flagsToString(this.mFlags));
            String r10 = "";
            if (this.mLinkUri != null) goto L5;
            String r11 = "";
        L6:
            r5.append(r11);
            if (this.mExtras == null) goto L11;
            r10 = ", hasExtras";
        L11:
            return j0.q(r5, r10, "}");
        L5:
            r11 = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
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

    public ContentInfoCompat(@NonNull Compat r5) {
        this.mCompat = r5;
    }

    @NonNull
    public static ClipData buildClipData(@NonNull ClipDescription r5, @NonNull List<ClipData.Item> r10) {
        ClipData r11 = new ClipData(new ClipDescription(r5), r10.get(0));
        int r12 = 1;
    L4:
        if (r12 >= r10.size()) goto L6;
        r11.addItem(r10.get(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String flagsToString(int r5) {
        if ((r5 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r5);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String sourceToString(int r5) {
        if (r5 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r5 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r5 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r5 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r5 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r5 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r5);
    }

    @NonNull
    @RequiresApi(31)
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo r5) {
        return new ContentInfoCompat(new Compat31Impl(r5));
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
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.Predicate<ClipData.Item> r5) {
        ClipData r10 = this.mCompat.getClip();
        if (r10.getItemCount() != 1) goto L12;
        boolean r11 = r5.test(r10.getItemAt(0));
        if (r11 == false) goto L7;
        ContentInfoCompat r12 = this;
    L8:
        if (r11 == false) goto L11;
        ContentInfoCompat this = null;
    L11:
        return Pair.create(r12, this);
    L7:
        r12 = null;
        goto L8
    L12:
        Pair<ClipData, ClipData> r13 = partition(r10, r5);
        if (r13.first != null) goto L17;
        return Pair.create(null, this);
    L17:
        if (r13.second != null) goto L21;
        return Pair.create(this, null);
    L21:
        return Pair.create(new Builder(this).setClip((ClipData) r13.first).build(), new Builder(this).setClip((ClipData) r13.second).build());
    }

    @NonNull
    @RequiresApi(31)
    public ContentInfo toContentInfo() {
        ContentInfo r5 = this.mCompat.getWrapped();
        Objects.requireNonNull(r5);
        return r5;
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }

    @NonNull
    public static Pair<ClipData, ClipData> partition(@NonNull ClipData r10, @NonNull androidx.core.util.Predicate<ClipData.Item> r11) {
        int r5 = 0;
        ArrayList r12 = null;
        ArrayList r13 = null;
    L4:
        if (r5 >= r10.getItemCount()) goto L14;
        ClipData.Item r14 = r10.getItemAt(r5);
        if (r11.test(r14) == false) goto L10;
        if (r12 != null) goto L9;
        r12 = new ArrayList();
    L9:
        r12.add(r14);
    L13:
        r5 = r5 + 1;
        goto L4
    L10:
        if (r13 != null) goto L12;
        r13 = new ArrayList();
    L12:
        r13.add(r14);
        goto L13
    L14:
        if (r12 == null) goto L16;
        if (r13 != null) goto L21;
        return Pair.create(r10, null);
    L21:
        return Pair.create(buildClipData(r10.getDescription(), r12), buildClipData(r10.getDescription(), r13));
    L16:
        return Pair.create(null, r10);
    }

    @NonNull
    @RequiresApi(31)
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r5, @NonNull Predicate<ClipData.Item> r10) {
        return Api31Impl.partition(r5, r10);
    }
}
