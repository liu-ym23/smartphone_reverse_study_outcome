package androidx.core.content;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
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
    public static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static String getIdentifier(Intent r5) {
            return r5.getIdentifier();
        }

        @DoNotInline
        public static Intent setIdentifier(Intent r5, String r10) {
            return r5.setIdentifier(r10);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static void checkOtherMembers(int r5, ClipData.Item r10, Consumer<String> r11) {
            if (r10.getHtmlText() == null) goto L5;
        L8:
            r11.accept("ClipData item at position " + r5 + " contains htmlText, textLinks or intent: " + r10);
            return;
        L5:
            if (r10.getIntent() != null) goto L8;
            if (r10.getTextLinks() != null) goto L8;
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
            this.mAllowedActions = new d(2);
            this.mAllowedData = new d(3);
            this.mAllowedTypes = new d(4);
            this.mAllowedCategories = new d(5);
            this.mAllowedPackages = new d(6);
            this.mAllowedComponents = new d(7);
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = new d(8);
            this.mAllowedClipData = new d(9);
        }

        public static /* synthetic */ boolean a(ComponentName r5) {
            return lambda$new$5(r5);
        }

        public static /* synthetic */ boolean b(String r5) {
            return lambda$new$2(r5);
        }

        public static /* synthetic */ boolean c(String r5, ComponentName r10) {
            return lambda$allowComponentWithPackage$9(r5, r10);
        }

        public static /* synthetic */ boolean d(Uri r5, String r10) {
            return lambda$allowClipDataUriWithAuthority$11(r10, r5);
        }

        public static /* synthetic */ boolean e(Class r5, Predicate r10, Object r11) {
            return lambda$allowExtra$13(r5, r10, r11);
        }

        public static /* synthetic */ boolean f(String r5) {
            return lambda$new$4(r5);
        }

        public static /* synthetic */ boolean g(Uri r5, String r10) {
            return lambda$allowExtraOutput$16(r10, r5);
        }

        public static /* synthetic */ boolean h(Uri r5, String r10) {
            return lambda$allowExtraStreamUriWithAuthority$15(r10, r5);
        }

        public static /* synthetic */ boolean i(Object r5) {
            return lambda$allowExtra$14(r5);
        }

        public static /* synthetic */ boolean j(ComponentName r5) {
            return lambda$allowAnyComponent$10(r5);
        }

        public static /* synthetic */ boolean k(String r5) {
            return lambda$new$3(r5);
        }

        public static /* synthetic */ boolean l(Uri r5) {
            return lambda$new$1(r5);
        }

        private static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName r5) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String r5, Uri r10) {
            return r5.equals(r10.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String r5, ComponentName r10) {
            return r5.equals(r10.getPackageName());
        }

        private static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String r5, Uri r10) {
            return r5.equals(r10.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtra$12(Object r5) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$13(Class r5, Predicate r10, Object r11) {
            if (r5.isInstance(r11) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.test(r5.cast(r11)) == false) goto L7;
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$14(Object r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$allowExtraOutput$16(String r5, Uri r10) {
            return r5.equals(r10.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String r5, Uri r10) {
            return r5.equals(r10.getAuthority());
        }

        private static /* synthetic */ boolean lambda$new$0(String r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$1(Uri r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$2(String r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$3(String r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$4(String r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$5(ComponentName r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$6(Uri r5) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$7(ClipData r5) {
            return false;
        }

        public static /* synthetic */ boolean m(Uri r5) {
            return lambda$new$6(r5);
        }

        public static /* synthetic */ boolean n(Uri r5, String r10) {
            return lambda$allowDataWithAuthority$8(r10, r5);
        }

        public static /* synthetic */ boolean o(Object r5) {
            return lambda$allowExtra$12(r5);
        }

        public static /* synthetic */ boolean p(String r5) {
            return lambda$new$0(r5);
        }

        public static /* synthetic */ boolean q(ClipData r5) {
            return lambda$new$7(r5);
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            Objects.requireNonNull(r5);
            allowAction(new b(r5, 1));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new d(0);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            Objects.requireNonNull(r5);
            return allowCategory(new b(r5, 1));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(@NonNull Predicate<ClipData> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedClipData = this.mAllowedClipData.or(r5);
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
        public Builder allowClipDataUri(@NonNull Predicate<Uri> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            return allowClipDataUri(new b(r5, 4));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull ComponentName r5) {
            Preconditions.checkNotNull(r5);
            Objects.requireNonNull(r5);
            return allowComponent(new c(r5, 0));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            return allowComponent(new b(r5, 2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(@NonNull Predicate<Uri> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedData = this.mAllowedData.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            allowData(new b(r5, 3));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r5, @NonNull Class<?> r10) {
            return allowExtra(r5, r10, new d(10));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull String r5) {
            allowExtra("output", Uri.class, new b(r5, 0));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(@NonNull Predicate<Uri> r5) {
            allowExtra("android.intent.extra.STREAM", Uri.class, r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            allowExtra("android.intent.extra.STREAM", Uri.class, new b(r5, 5));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int r5) {
            this.mAllowedFlags = r5 | this.mAllowedFlags;
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
        public Builder allowPackage(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            Objects.requireNonNull(r5);
            return allowPackage(new b(r5, 1));
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
        public Builder allowType(@NonNull String r5) {
            Preconditions.checkNotNull(r5);
            Objects.requireNonNull(r5);
            return allowType(new b(r5, 1));
        }

        @NonNull
        public IntentSanitizer build() {
            boolean r5 = this.mAllowAnyComponent;
            if (r5 == true) goto L5;
        L6:
            if (r5 == false) goto L8;
        L12:
            IntentSanitizer r10 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r10, this.mAllowedFlags);
            IntentSanitizer.access$202(r10, this.mAllowedActions);
            IntentSanitizer.access$302(r10, this.mAllowedData);
            IntentSanitizer.access$402(r10, this.mAllowedTypes);
            IntentSanitizer.access$502(r10, this.mAllowedCategories);
            IntentSanitizer.access$602(r10, this.mAllowedPackages);
            IntentSanitizer.access$702(r10, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r10, this.mAllowedComponents);
            IntentSanitizer.access$902(r10, this.mAllowedExtras);
            IntentSanitizer.access$1002(r10, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r10, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r10, this.mAllowedClipData);
            IntentSanitizer.access$1302(r10, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r10, this.mAllowSelector);
            IntentSanitizer.access$1502(r10, this.mAllowSourceBounds);
            return r10;
        L8:
            if (this.mAllowSomeComponents == true) goto L12;
        L11:
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        L5:
            if (this.mAllowSomeComponents == true) goto L11;
            goto L6
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(@NonNull String r5, @NonNull Class<T> r10, @NonNull Predicate<T> r11) {
            Preconditions.checkNotNull(r5);
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            return allowExtra(r5, new androidx.core.util.a(r10, r11));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull Predicate<Uri> r5) {
            allowExtra("output", Uri.class, r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull Predicate<String> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedActions = this.mAllowedActions.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull Predicate<String> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedCategories = this.mAllowedCategories.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull Predicate<ComponentName> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull Predicate<String> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedPackages = this.mAllowedPackages.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull Predicate<String> r5) {
            Preconditions.checkNotNull(r5);
            this.mAllowedTypes = this.mAllowedTypes.or(r5);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r5, @NonNull Predicate<Object> r10) {
            Preconditions.checkNotNull(r5);
            Preconditions.checkNotNull(r10);
            Predicate<Object> r11 = this.mAllowedExtras.get(r5);
            if (r11 != null) goto L5;
            r11 = new d(1);
        L5:
            Predicate<Object> r12 = r11.or(r10);
            this.mAllowedExtras.put(r5, r12);
            return this;
        }
    }

    public /* synthetic */ IntentSanitizer(AnonymousClass1 r5) {
        this();
    }

    public static /* synthetic */ void a(String r5) {
        lambda$sanitizeByThrowing$1(r5);
    }

    public static /* synthetic */ boolean access$1002(IntentSanitizer r5, boolean r10) {
        r5.mAllowClipDataText = r10;
        return r10;
    }

    public static /* synthetic */ int access$102(IntentSanitizer r5, int r10) {
        r5.mAllowedFlags = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$1102(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedClipDataUri = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$1202(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedClipData = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1302(IntentSanitizer r5, boolean r10) {
        r5.mAllowIdentifier = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1402(IntentSanitizer r5, boolean r10) {
        r5.mAllowSelector = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1502(IntentSanitizer r5, boolean r10) {
        r5.mAllowSourceBounds = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$202(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedActions = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$302(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedData = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$402(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedTypes = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$502(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedCategories = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$602(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedPackages = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$702(IntentSanitizer r5, boolean r10) {
        r5.mAllowAnyComponent = r10;
        return r10;
    }

    public static /* synthetic */ Predicate access$802(IntentSanitizer r5, Predicate r10) {
        r5.mAllowedComponents = r10;
        return r10;
    }

    public static /* synthetic */ Map access$902(IntentSanitizer r5, Map r10) {
        r5.mAllowedExtras = r10;
        return r10;
    }

    public static /* synthetic */ void b(String r5) {
        lambda$sanitizeByFiltering$0(r5);
    }

    private static void checkOtherMembers(int r5, ClipData.Item r10, Consumer<String> r11) {
        if (r10.getHtmlText() == null) goto L5;
    L6:
        r11.accept("ClipData item at position " + r5 + " contains htmlText, textLinks or intent: " + r10);
        return;
    L5:
        if (r10.getIntent() != null) goto L6;
    }

    private static /* synthetic */ void lambda$sanitizeByFiltering$0(String r5) {
    }

    private static /* synthetic */ void lambda$sanitizeByThrowing$1(String r5) {
        throw new SecurityException(r5);
    }

    private void putExtra(Intent r5, String r10, Object r11) {
        if (r11 != null) goto L5;
        r5.getExtras().putString(r10, null);
        return;
    L5:
        if ((r11 instanceof Parcelable) == false) goto L8;
        r5.putExtra(r10, (Parcelable) r11);
        return;
    L8:
        if ((r11 instanceof Parcelable[]) == false) goto L11;
        r5.putExtra(r10, (Parcelable[]) r11);
        return;
    L11:
        if ((r11 instanceof Serializable) == false) goto L15;
        r5.putExtra(r10, (Serializable) r11);
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r11.getClass());
    }

    public static void sanitizeClipData(@NonNull Intent r10, Intent r11, Predicate<ClipData> r12, boolean r13, Predicate<Uri> r14, Consumer<String> r15) {
        ClipData r16 = r10.getClipData();
        if (r16 != null) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
    L9:
        int r5 = 0;
        ClipData r17 = null;
    L11:
        if (r5 >= r16.getItemCount()) goto L38;
        ClipData.Item r18 = r16.getItemAt(r5);
        Api31Impl.checkOtherMembers(r5, r18, r15);
        if (r13 == false) goto L16;
        CharSequence r19 = r18.getText();
    L20:
        if (r14 != null) goto L25;
        if (r18.getUri() == null) goto L30;
        StringBuilder r20 = j0.s(r5, "Item URI is not allowed. Item position: ", ". URI: ");
        r20.append(r18.getUri());
        r15.accept(r20.toString());
    L30:
        Uri r21 = null;
    L32:
        if (r19 != null) goto L34;
        if (r21 != null) goto L34;
    L37:
        r5 = r5 + 1;
    L34:
        if (r17 != null) goto L36;
        r17 = new ClipData(r16.getDescription(), new ClipData.Item(r19, null, r21));
        goto L37
    L36:
        r17.addItem(new ClipData.Item(r19, null, r21));
        goto L37
    L25:
        if (r18.getUri() != null) goto L27;
    L31:
        r21 = r18.getUri();
        goto L32
    L27:
        if (r14.test(r18.getUri()) == true) goto L31;
        StringBuilder r22 = j0.s(r5, "Item URI is not allowed. Item position: ", ". URI: ");
        r22.append(r18.getUri());
        r15.accept(r22.toString());
        goto L30
    L16:
        if (r18.getText() == null) goto L18;
        StringBuilder r23 = j0.s(r5, "Item text cannot contain value. Item position: ", ". Text: ");
        r23.append(r18.getText());
        r15.accept(r23.toString());
    L18:
        r19 = null;
        goto L20
    L38:
        if (r17 == null) goto L46;
        r11.setClipData(r17);
        return;
    L46:
        return;
    L7:
        if (r12.test(r16) == false) goto L9;
        r11.setClipData(r16);
    }

    @NonNull
    public Intent sanitize(@NonNull Intent r10, @NonNull Consumer<String> r11) {
        Intent r12 = new Intent();
        ComponentName r5 = r10.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r5 != null) goto L6;
    L7:
        r12.setComponent(r5);
    L9:
        String r13 = r10.getPackage();
        if (r13 != null) goto L12;
    L15:
        r12.setPackage(r13);
    L16:
        int r14 = this.mAllowedFlags | r10.getFlags();
        int r15 = this.mAllowedFlags;
        if (r14 != r15) goto L19;
        r12.setFlags(r10.getFlags());
    L20:
        String r16 = r10.getAction();
        if (r16 != null) goto L23;
    L26:
        r12.setAction(r16);
    L27:
        Uri r17 = r10.getData();
        if (r17 != null) goto L30;
    L33:
        r12.setData(r17);
    L34:
        String r18 = r10.getType();
        if (r18 != null) goto L37;
    L40:
        r12.setDataAndType(r12.getData(), r18);
    L41:
        Set<String> r19 = r10.getCategories();
        if (r19 == null) goto L50;
        Iterator<String> r20 = r19.iterator();
    L45:
        if (r20.hasNext() == false) goto L50;
        String r21 = r20.next();
        if (this.mAllowedCategories.test(r21) == true) goto L48;
        r11.accept("Category is not allowed: " + r21);
        goto L45
    L48:
        r12.addCategory(r21);
    L50:
        Bundle r22 = r10.getExtras();
        if (r22 == null) goto L71;
        Iterator<String> r23 = r22.keySet().iterator();
    L54:
        if (r23.hasNext() == false) goto L71;
        String r24 = r23.next();
        if (r24.equals("android.intent.extra.STREAM") == false) goto L61;
        if ((this.mAllowedFlags & 1) != 0) goto L61;
        r11.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
    L61:
        if (r24.equals("output") == false) goto L65;
        if (((~this.mAllowedFlags) & 3) == 0) goto L65;
        r11.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
    L65:
        Object r25 = r22.get(r24);
        Predicate<Object> r26 = this.mAllowedExtras.get(r24);
        if (r26 == null) goto L70;
        if (r26.test(r25) == false) goto L70;
        putExtra(r12, r24, r25);
    L70:
        r11.accept("Extra is not allowed. Key: " + r24 + ". Value: " + r25);
    L71:
        sanitizeClipData(r10, r12, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r11);
        if (this.mAllowIdentifier == false) goto L75;
        Api29Impl.setIdentifier(r12, Api29Impl.getIdentifier(r10));
    L78:
        if (this.mAllowSelector == false) goto L81;
        r12.setSelector(r10.getSelector());
    L84:
        if (this.mAllowSourceBounds == false) goto L87;
        r12.setSourceBounds(r10.getSourceBounds());
    L89:
        return r12;
    L87:
        if (r10.getSourceBounds() == null) goto L89;
        r11.accept("SourceBounds is not allowed: " + r10.getSourceBounds());
        goto L89
    L81:
        if (r10.getSelector() == null) goto L84;
        r11.accept("Selector is not allowed: " + r10.getSelector());
        goto L84
    L75:
        if (Api29Impl.getIdentifier(r10) == null) goto L78;
        r11.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r10));
        goto L78
    L37:
        if (this.mAllowedTypes.test(r18) == true) goto L40;
        r11.accept("Type is not allowed: ".concat(r18));
        goto L41
    L30:
        if (this.mAllowedData.test(r17) == true) goto L33;
        r11.accept("Data is not allowed: " + r17);
        goto L34
    L23:
        if (this.mAllowedActions.test(r16) == true) goto L26;
        r11.accept("Action is not allowed: ".concat(r16));
        goto L27
    L19:
        r12.setFlags(r10.getFlags() & r15);
        r11.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r10.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r13) == true) goto L15;
        r11.accept("Package is not allowed: ".concat(r13));
    L6:
        if (this.mAllowedComponents.test(r5) == true) goto L7;
        r11.accept("Component is not allowed: " + r5);
        r12.setComponent(new ComponentName("android", "java.lang.Void"));
        goto L9
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent r5) {
        return sanitize(r5, new a(1));
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent r5) {
        return sanitize(r5, new a(0));
    }

    private IntentSanitizer() {
    }
}
