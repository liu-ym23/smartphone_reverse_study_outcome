package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    /* JADX INFO: renamed from: androidx.core.content.IntentSanitizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(15)
    private static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Intent getSelector(Intent r10) {
            return r10.getSelector();
        }

        @DoNotInline
        static void setSelector(Intent r10, Intent r11) {
            r10.setSelector(r11);
        }
    }

    @RequiresApi(16)
    private static class Api16Impl {

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static void checkOtherMembers(int r10, ClipData.Item r11, Consumer<String> r12) {
                if (r11.getHtmlText() == null) goto L5;
            L8:
                r12.accept("ClipData item at position " + r10 + " contains htmlText, textLinks or intent: " + r11);
                return;
            L5:
                if (r11.getIntent() != null) goto L8;
                if (r11.getTextLinks() != null) goto L8;
            }
        }

        private Api16Impl() {
        }

        private static void checkOtherMembers(int r10, ClipData.Item r11, Consumer<String> r12) {
            if (r11.getHtmlText() == null) goto L5;
        L6:
            r12.accept("ClipData item at position " + r10 + " contains htmlText, textLinks or intent: " + r11);
            return;
        L5:
            if (r11.getIntent() != null) goto L6;
        }

        @DoNotInline
        static void sanitizeClipData(@NonNull Intent r10, Intent r11, Predicate<ClipData> r12, boolean r13, Predicate<Uri> r14, Consumer<String> r15) {
            ClipData r16 = r10.getClipData();
            if (r16 != null) goto L5;
            return;
        L5:
            if (r12 != null) goto L7;
        L9:
            int r17 = 0;
            ClipData r18 = null;
        L11:
            if (r17 >= r16.getItemCount()) goto L40;
            ClipData.Item r19 = r16.getItemAt(r17);
            if (Build.VERSION.SDK_INT < 31) goto L15;
            Api31Impl.checkOtherMembers(r17, r19, r15);
        L16:
            CharSequence r20 = r19.getText();
            if (r13 == true) goto L22;
            if (r20 == null) goto L21;
            r15.accept("Item text cannot contain value. Item position: " + r17 + ". Text: " + r19.getText());
        L21:
            r20 = null;
        L22:
            Uri r21 = r19.getUri();
            if (r14 != null) goto L27;
            if (r21 == null) goto L32;
            StringBuilder r22 = new StringBuilder();
        L26:
            r22.append("Item URI is not allowed. Item position: ");
            r22.append(r17);
            r22.append(". URI: ");
            r22.append(r19.getUri());
            r15.accept(r22.toString());
        L32:
            Uri r23 = null;
        L34:
            if (r20 != null) goto L36;
            if (r23 != null) goto L36;
        L39:
            r17 = r17 + 1;
        L36:
            if (r18 != null) goto L38;
            r18 = new ClipData(r16.getDescription(), new ClipData.Item(r20, null, r23));
            goto L39
        L38:
            r18.addItem(new ClipData.Item(r20, null, r23));
            goto L39
        L27:
            if (r21 != null) goto L29;
        L33:
            r23 = r19.getUri();
            goto L34
        L29:
            if (r14.test(r19.getUri()) == true) goto L33;
            r22 = new StringBuilder();
            goto L26
        L15:
            checkOtherMembers(r17, r19, r15);
            goto L16
        L40:
            if (r18 == null) goto L48;
            r11.setClipData(r18);
            return;
        L48:
            return;
        L7:
            if (r12.test(r16) == false) goto L9;
            r11.setClipData(r16);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static String getIdentifier(Intent r10) {
            return r10.getIdentifier();
        }

        @DoNotInline
        static Intent setIdentifier(Intent r10, String r11) {
            return r10.setIdentifier(r11);
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions;
        private Predicate<String> mAllowedCategories;
        private Predicate<ClipData> mAllowedClipData;
        private Predicate<Uri> mAllowedClipDataUri;
        private Predicate<ComponentName> mAllowedComponents;
        private Predicate<Uri> mAllowedData;
        private Map<String, Predicate<Object>> mAllowedExtras;
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages;
        private Predicate<String> mAllowedTypes;

        public Builder() {
            this.mAllowedActions = h.f273a;
            this.mAllowedData = f.f271a;
            this.mAllowedTypes = g.f272a;
            this.mAllowedCategories = j.f275a;
            this.mAllowedPackages = i.f274a;
            this.mAllowedComponents = d.f269a;
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = e.f270a;
            this.mAllowedClipData = t.f290a;
        }

        public static /* synthetic */ boolean a(String r10) {
            return lambda$new$2(r10);
        }

        public static /* synthetic */ boolean b(Uri r10) {
            return lambda$new$6(r10);
        }

        public static /* synthetic */ boolean c(String r10, Uri r11) {
            return lambda$allowExtraOutput$16(r10, r11);
        }

        public static /* synthetic */ boolean d(ComponentName r10) {
            return lambda$allowAnyComponent$10(r10);
        }

        public static /* synthetic */ boolean e(String r10) {
            return lambda$new$0(r10);
        }

        public static /* synthetic */ boolean f(Object r10) {
            return lambda$allowExtra$14(r10);
        }

        public static /* synthetic */ boolean g(String r10, Uri r11) {
            return lambda$allowClipDataUriWithAuthority$11(r10, r11);
        }

        public static /* synthetic */ boolean h(String r10) {
            return lambda$new$4(r10);
        }

        public static /* synthetic */ boolean i(Uri r10) {
            return lambda$new$1(r10);
        }

        public static /* synthetic */ boolean j(String r10) {
            return lambda$new$3(r10);
        }

        public static /* synthetic */ boolean k(String r10, Uri r11) {
            return lambda$allowDataWithAuthority$8(r10, r11);
        }

        public static /* synthetic */ boolean l(Object r10) {
            return lambda$allowExtra$12(r10);
        }

        private static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName r10) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String r10, Uri r11) {
            return r10.equals(r11.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String r10, ComponentName r11) {
            return r10.equals(r11.getPackageName());
        }

        private static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String r10, Uri r11) {
            return r10.equals(r11.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtra$12(Object r10) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$13(Class r10, Predicate r11, Object r12) {
            if (r10.isInstance(r12) == true) goto L5;
        L7:
            return false;
        L5:
            if (r11.test(r10.cast(r12)) == false) goto L7;
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$14(Object r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$allowExtraOutput$16(String r10, Uri r11) {
            return r10.equals(r11.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String r10, Uri r11) {
            return r10.equals(r11.getAuthority());
        }

        private static /* synthetic */ boolean lambda$new$0(String r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$1(Uri r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$2(String r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$3(String r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$4(String r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$5(ComponentName r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$6(Uri r10) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$7(ClipData r10) {
            return false;
        }

        public static /* synthetic */ boolean m(String r10, ComponentName r11) {
            return lambda$allowComponentWithPackage$9(r10, r11);
        }

        public static /* synthetic */ boolean n(String r10, Uri r11) {
            return lambda$allowExtraStreamUriWithAuthority$15(r10, r11);
        }

        public static /* synthetic */ boolean o(ComponentName r10) {
            return lambda$new$5(r10);
        }

        public static /* synthetic */ boolean p(Class r10, Predicate r11, Object r12) {
            return lambda$allowExtra$13(r10, r11, r12);
        }

        public static /* synthetic */ boolean q(ClipData r10) {
            return lambda$new$7(r10);
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull Predicate<String> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedActions = this.mAllowedActions.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull String r10) {
            Preconditions.checkNotNull(r10);
            Objects.requireNonNull(r10);
            allowAction(new s(r10));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = u.f291a;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull Predicate<String> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedCategories = this.mAllowedCategories.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull String r10) {
            Preconditions.checkNotNull(r10);
            Objects.requireNonNull(r10);
            return allowCategory(new s(r10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(@NonNull Predicate<ClipData> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedClipData = this.mAllowedClipData.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUri(@NonNull Predicate<Uri> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(@NonNull final String r10) {
            Preconditions.checkNotNull(r10);
            return allowClipDataUri(new p(r10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull final ComponentName r10) {
            Preconditions.checkNotNull(r10);
            Objects.requireNonNull(r10);
            return allowComponent(new c(r10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull Predicate<ComponentName> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(@NonNull final String r10) {
            Preconditions.checkNotNull(r10);
            return allowComponent(new n(r10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(@NonNull Predicate<Uri> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedData = this.mAllowedData.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(@NonNull final String r10) {
            Preconditions.checkNotNull(r10);
            allowData(new q(r10));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r10, @NonNull Predicate<Object> r11) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            Predicate<Object> r12 = this.mAllowedExtras.get(r10);
            if (r12 != null) goto L5;
            r12 = k.f276a;
        L5:
            Predicate<Object> r13 = r12.or(r11);
            this.mAllowedExtras.put(r10, r13);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r10, @NonNull Class<?> r11) {
            return allowExtra(r10, r11, l.f277a);
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(@NonNull String r10, @NonNull final Class<T> r11, @NonNull final Predicate<T> r12) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            Preconditions.checkNotNull(r12);
            return allowExtra(r10, new m(r11, r12));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull Predicate<Uri> r10) {
            allowExtra("output", Uri.class, r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull final String r10) {
            allowExtra("output", Uri.class, new o(r10));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(@NonNull Predicate<Uri> r10) {
            allowExtra("android.intent.extra.STREAM", Uri.class, r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(@NonNull final String r10) {
            Preconditions.checkNotNull(r10);
            allowExtra("android.intent.extra.STREAM", Uri.class, new r(r10));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int r10) {
            this.mAllowedFlags = r10 | this.mAllowedFlags;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull Predicate<String> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedPackages = this.mAllowedPackages.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull String r10) {
            Preconditions.checkNotNull(r10);
            Objects.requireNonNull(r10);
            return allowPackage(new s(r10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull Predicate<String> r10) {
            Preconditions.checkNotNull(r10);
            this.mAllowedTypes = this.mAllowedTypes.or(r10);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull String r10) {
            Preconditions.checkNotNull(r10);
            Objects.requireNonNull(r10);
            return allowType(new s(r10));
        }

        @NonNull
        @SuppressLint({"SyntheticAccessor"})
        public IntentSanitizer build() {
            boolean r10 = this.mAllowAnyComponent;
            if (r10 == true) goto L5;
        L6:
            if (r10 == false) goto L8;
        L12:
            IntentSanitizer r11 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r11, this.mAllowedFlags);
            IntentSanitizer.access$202(r11, this.mAllowedActions);
            IntentSanitizer.access$302(r11, this.mAllowedData);
            IntentSanitizer.access$402(r11, this.mAllowedTypes);
            IntentSanitizer.access$502(r11, this.mAllowedCategories);
            IntentSanitizer.access$602(r11, this.mAllowedPackages);
            IntentSanitizer.access$702(r11, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r11, this.mAllowedComponents);
            IntentSanitizer.access$902(r11, this.mAllowedExtras);
            IntentSanitizer.access$1002(r11, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r11, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r11, this.mAllowedClipData);
            IntentSanitizer.access$1302(r11, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r11, this.mAllowSelector);
            IntentSanitizer.access$1502(r11, this.mAllowSourceBounds);
            return r11;
        L8:
            if (this.mAllowSomeComponents == true) goto L12;
        L11:
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        L5:
            if (this.mAllowSomeComponents == true) goto L11;
            goto L6
        }
    }

    private IntentSanitizer() {
    }

    /* synthetic */ IntentSanitizer(AnonymousClass1 r10) {
        this();
    }

    public static /* synthetic */ void a(String r10) {
        lambda$sanitizeByThrowing$1(r10);
    }

    static /* synthetic */ boolean access$1002(IntentSanitizer r10, boolean r11) {
        r10.mAllowClipDataText = r11;
        return r11;
    }

    static /* synthetic */ int access$102(IntentSanitizer r10, int r11) {
        r10.mAllowedFlags = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$1102(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedClipDataUri = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$1202(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedClipData = r11;
        return r11;
    }

    static /* synthetic */ boolean access$1302(IntentSanitizer r10, boolean r11) {
        r10.mAllowIdentifier = r11;
        return r11;
    }

    static /* synthetic */ boolean access$1402(IntentSanitizer r10, boolean r11) {
        r10.mAllowSelector = r11;
        return r11;
    }

    static /* synthetic */ boolean access$1502(IntentSanitizer r10, boolean r11) {
        r10.mAllowSourceBounds = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$202(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedActions = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$302(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedData = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$402(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedTypes = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$502(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedCategories = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$602(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedPackages = r11;
        return r11;
    }

    static /* synthetic */ boolean access$702(IntentSanitizer r10, boolean r11) {
        r10.mAllowAnyComponent = r11;
        return r11;
    }

    static /* synthetic */ Predicate access$802(IntentSanitizer r10, Predicate r11) {
        r10.mAllowedComponents = r11;
        return r11;
    }

    static /* synthetic */ Map access$902(IntentSanitizer r10, Map r11) {
        r10.mAllowedExtras = r11;
        return r11;
    }

    public static /* synthetic */ void b(String r10) {
        lambda$sanitizeByFiltering$0(r10);
    }

    private static /* synthetic */ void lambda$sanitizeByFiltering$0(String r10) {
    }

    private static /* synthetic */ void lambda$sanitizeByThrowing$1(String r10) {
        throw new SecurityException(r10);
    }

    private void putExtra(Intent r10, String r11, Object r12) {
        if (r12 != null) goto L5;
        r10.getExtras().putString(r11, null);
        return;
    L5:
        if ((r12 instanceof Parcelable) == false) goto L8;
        r10.putExtra(r11, (Parcelable) r12);
        return;
    L8:
        if ((r12 instanceof Parcelable[]) == false) goto L11;
        r10.putExtra(r11, (Parcelable[]) r12);
        return;
    L11:
        if ((r12 instanceof Serializable) == false) goto L15;
        r10.putExtra(r11, (Serializable) r12);
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r12.getClass());
    }

    @NonNull
    public Intent sanitize(@NonNull Intent r10, @NonNull Consumer<String> r11) {
        Intent r12 = new Intent();
        ComponentName r13 = r10.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r13 != null) goto L6;
    L7:
        r12.setComponent(r13);
        String r14 = r10.getPackage();
        if (r14 != null) goto L12;
    L15:
        r12.setPackage(r14);
    L16:
        int r15 = this.mAllowedFlags | r10.getFlags();
        int r16 = this.mAllowedFlags;
        if (r15 != r16) goto L19;
        r12.setFlags(r10.getFlags());
    L20:
        String r17 = r10.getAction();
        if (r17 != null) goto L23;
    L26:
        r12.setAction(r17);
    L27:
        Uri r18 = r10.getData();
        if (r18 != null) goto L30;
    L33:
        r12.setData(r18);
    L34:
        String r19 = r10.getType();
        if (r19 != null) goto L37;
    L40:
        r12.setDataAndType(r12.getData(), r19);
    L41:
        Set<String> r20 = r10.getCategories();
        if (r20 == null) goto L50;
        Iterator<String> r21 = r20.iterator();
    L45:
        if (r21.hasNext() == false) goto L50;
        String r22 = r21.next();
        if (this.mAllowedCategories.test(r22) == true) goto L48;
        r11.accept("Category is not allowed: " + r22);
        goto L45
    L48:
        r12.addCategory(r22);
    L50:
        Bundle r23 = r10.getExtras();
        if (r23 == null) goto L72;
        Iterator<String> r24 = r23.keySet().iterator();
    L54:
        if (r24.hasNext() == false) goto L72;
        String r25 = r24.next();
        if (r25.equals("android.intent.extra.STREAM") == false) goto L62;
        if ((this.mAllowedFlags & 1) != 0) goto L62;
        String r26 = "Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.";
    L60:
        r11.accept(r26);
    L62:
        if (r25.equals("output") == true) goto L64;
    L66:
        Object r27 = r23.get(r25);
        Predicate<Object> r28 = this.mAllowedExtras.get(r25);
        if (r28 == null) goto L71;
        if (r28.test(r27) == false) goto L71;
        putExtra(r12, r25, r27);
    L71:
        r26 = "Extra is not allowed. Key: " + r25 + ". Value: " + r27;
        goto L60
    L64:
        if (((~this.mAllowedFlags) & 3) == 0) goto L66;
        r26 = "Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.";
    L72:
        int r29 = Build.VERSION.SDK_INT;
        if (r29 < 16) goto L76;
        Api16Impl.sanitizeClipData(r10, r12, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r11);
    L76:
        if (r29 < 29) goto L84;
        if (this.mAllowIdentifier == false) goto L81;
        Api29Impl.setIdentifier(r12, Api29Impl.getIdentifier(r10));
        goto L84
    L81:
        if (Api29Impl.getIdentifier(r10) == null) goto L84;
        r11.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r10));
    L84:
        if (r29 < 15) goto L92;
        if (this.mAllowSelector == false) goto L89;
        Api15Impl.setSelector(r12, Api15Impl.getSelector(r10));
        goto L92
    L89:
        if (Api15Impl.getSelector(r10) == null) goto L92;
        r11.accept("Selector is not allowed: " + Api15Impl.getSelector(r10));
    L92:
        if (this.mAllowSourceBounds == false) goto L95;
        r12.setSourceBounds(r10.getSourceBounds());
    L97:
        return r12;
    L95:
        if (r10.getSourceBounds() == null) goto L97;
        r11.accept("SourceBounds is not allowed: " + r10.getSourceBounds());
        goto L97
    L37:
        if (this.mAllowedTypes.test(r19) == true) goto L40;
        r11.accept("Type is not allowed: " + r19);
        goto L41
    L30:
        if (this.mAllowedData.test(r18) == true) goto L33;
        r11.accept("Data is not allowed: " + r18);
        goto L34
    L23:
        if (this.mAllowedActions.test(r17) == true) goto L26;
        r11.accept("Action is not allowed: " + r17);
        goto L27
    L19:
        r12.setFlags(r10.getFlags() & r16);
        r11.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r10.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r14) == true) goto L15;
        r11.accept("Package is not allowed: " + r14);
    L6:
        if (this.mAllowedComponents.test(r13) == true) goto L7;
        r11.accept("Component is not allowed: " + r13);
        r13 = new ComponentName("android", "java.lang.Void");
        goto L7
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent r10) {
        return sanitize(r10, b.f267c);
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent r10) {
        return sanitize(r10, a.f266c);
    }
}
