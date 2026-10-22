package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class Api15Impl {
        private Api15Impl() {
        }

        static Intent getSelector(Intent r0) {
            return r0.getSelector();
        }

        static void setSelector(Intent r0, Intent r1) {
            r0.setSelector(r1);
        }
    }

    private static class Api16Impl {

        private static class Api31Impl {
            private Api31Impl() {
            }

            static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
                Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
                if (r3.getHtmlText() == null) goto L5;
            L8:
                r5.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
                return;
            L5:
                if (r3.getIntent() != null) goto L8;
                if (r3.getTextLinks() != null) goto L8;
            }
        }

        private Api16Impl() {
        }

        private static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
            if (r3.getHtmlText() == null) goto L5;
        L6:
            r5.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
            return;
        L5:
            if (r3.getIntent() != null) goto L6;
        }

        static void sanitizeClipData(Intent r7, Intent r8, Predicate<ClipData> r9, boolean r10, Predicate<Uri> r11, Consumer<String> r12) {
            Predicate r13 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r9, Predicate.class, "com.obric.memorydata.plugin");
            Predicate r14 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r11, Predicate.class, "com.obric.memorydata.plugin");
            Consumer r15 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r12, Consumer.class, "com.obric.memorydata.plugin");
            ClipData r16 = r7.getClipData();
            if (r16 != null) goto L5;
            return;
        L5:
            if (r13 != null) goto L7;
        L9:
            int r17 = 0;
            ClipData r1 = null;
        L11:
            if (r17 >= r16.getItemCount()) goto L40;
            ClipData.Item r2 = r16.getItemAt(r17);
            if (Build.VERSION.SDK_INT < 31) goto L15;
            Api31Impl.checkOtherMembers(r17, r2, r15);
        L16:
            CharSequence r3 = r2.getText();
            if (r10 == true) goto L22;
            if (r3 == null) goto L21;
            r15.accept("Item text cannot contain value. Item position: " + r17 + ". Text: " + r2.getText());
        L21:
            r3 = null;
        L22:
            Uri r6 = r2.getUri();
            if (r14 != null) goto L27;
            if (r6 == null) goto L32;
            StringBuilder r18 = new StringBuilder();
        L26:
            r15.accept(r18.append("Item URI is not allowed. Item position: ").append(r17).append(". URI: ").append(r2.getUri()).toString());
        L32:
            Uri r4 = null;
        L34:
            if (r3 != null) goto L36;
            if (r4 != null) goto L36;
        L39:
            r17 = r17 + 1;
        L36:
            if (r1 != null) goto L38;
            r1 = new ClipData(r16.getDescription(), new ClipData.Item(r3, null, r4));
            goto L39
        L38:
            r1.addItem(new ClipData.Item(r3, null, r4));
            goto L39
        L27:
            if (r6 != null) goto L29;
        L33:
            r4 = r2.getUri();
            goto L34
        L29:
            if (r14.test(r2.getUri()) == true) goto L33;
            r18 = new StringBuilder();
            goto L26
        L15:
            checkOtherMembers(r17, r2, r15);
            goto L16
        L40:
            if (r1 == null) goto L48;
            r8.setClipData(r1);
            return;
        L48:
            return;
        L7:
            if (r13.test(r16) == false) goto L9;
            r8.setClipData(r16);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static String getIdentifier(Intent r0) {
            return r0.getIdentifier();
        }

        static Intent setIdentifier(Intent r0, String r1) {
            return r0.setIdentifier(r1);
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
            this.mAllowedActions = $$Lambda$IntentSanitizer$Builder$JLHq9UnD7GuExNJ8qTW9WH_UCM.INSTANCE;
            this.mAllowedData = $$Lambda$IntentSanitizer$Builder$NqpErgsNiCCwonMewIjQVkdTQ.INSTANCE;
            this.mAllowedTypes = $$Lambda$IntentSanitizer$Builder$4U_GfrIZHjV6ewfvuClRif5BQ4U.INSTANCE;
            this.mAllowedCategories = $$Lambda$IntentSanitizer$Builder$QGDXK6Iz77ZiVenuuvMgcuYOdA.INSTANCE;
            this.mAllowedPackages = $$Lambda$IntentSanitizer$Builder$LhhAvyYhT2VWSWan7HxDqulwnIA.INSTANCE;
            this.mAllowedComponents = $$Lambda$IntentSanitizer$Builder$iAMpnB3kBE20tG9ZfpyJMElSSs.INSTANCE;
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = $$Lambda$IntentSanitizer$Builder$7_PLI9sHfaphUUwfc7c0K0hj4.INSTANCE;
            this.mAllowedClipData = $$Lambda$IntentSanitizer$Builder$u88Zh5ZHnZ5xxf_Hz5dGwcPRwzU.INSTANCE;
        }

        static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName r0) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String r0, ComponentName r1) {
            return r0.equals(r1.getPackageName());
        }

        static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowExtra$12(Object r0) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowExtra$13(Class r2, Predicate r3, Object r4) {
            Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, r4) == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.test(r2.cast(r4)) == false) goto L7;
            return true;
        }

        static /* synthetic */ boolean lambda$allowExtra$14(Object r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$allowExtraOutput$16(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        /* JADX INFO: renamed from: lambda$f9aU52V4hLVPTW2v-TcMiSk5YDc, reason: not valid java name */
        public static /* synthetic */ boolean m41lambda$f9aU52V4hLVPTW2vTcMiSk5YDc(ComponentName r0, Object r1) {
            return r0.equals(r1);
        }

        static /* synthetic */ boolean lambda$new$0(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$1(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$2(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$3(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$4(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$5(ComponentName r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$6(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$7(ClipData r0) {
            return false;
        }

        public static /* synthetic */ boolean lambda$yzjFOqRUGseo4jtNtyZsqFTIwRc(String r0, Object r1) {
            return r0.equals(r1);
        }

        public Builder allowAction(Predicate<String> r3) {
            Predicate<? super String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedActions = this.mAllowedActions.or(r4);
            return this;
        }

        public Builder allowAction(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            allowAction(new $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc(r2));
            return this;
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = $$Lambda$IntentSanitizer$Builder$FsaUUrhV33pck7xEcNErjp6tI.INSTANCE;
            return this;
        }

        public Builder allowCategory(Predicate<String> r3) {
            Predicate<? super String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedCategories = this.mAllowedCategories.or(r4);
            return this;
        }

        public Builder allowCategory(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowCategory(new $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc(r2));
        }

        public Builder allowClipData(Predicate<ClipData> r3) {
            Predicate<? super ClipData> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedClipData = this.mAllowedClipData.or(r4);
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowClipDataUri(Predicate<Uri> r3) {
            Predicate<? super Uri> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r4);
            return this;
        }

        public Builder allowClipDataUriWithAuthority(final String r2) {
            Preconditions.checkNotNull(r2);
            return allowClipDataUri(new $$Lambda$IntentSanitizer$Builder$KxwlvcZEZo6c8ioUfyJK8aiwg(r2));
        }

        public Builder allowComponent(final ComponentName r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowComponent(new $$Lambda$IntentSanitizer$Builder$f9aU52V4hLVPTW2vTcMiSk5YDc(r2));
        }

        public Builder allowComponent(Predicate<ComponentName> r3) {
            Predicate<? super ComponentName> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r4);
            return this;
        }

        public Builder allowComponentWithPackage(final String r2) {
            Preconditions.checkNotNull(r2);
            return allowComponent(new $$Lambda$IntentSanitizer$Builder$eGekpZtVpL_YVf2hPyzEPlEMe4(r2));
        }

        public Builder allowData(Predicate<Uri> r3) {
            Predicate<? super Uri> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedData = this.mAllowedData.or(r4);
            return this;
        }

        public Builder allowDataWithAuthority(final String r2) {
            Preconditions.checkNotNull(r2);
            allowData(new $$Lambda$IntentSanitizer$Builder$Xpt8uzicbIAL7681iZQzx_qLWI(r2));
            return this;
        }

        public Builder allowExtra(String r4, Predicate<Object> r5) {
            Predicate r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            Preconditions.checkNotNull(r6);
            Predicate r0 = (Predicate) ZeusTransformUtils.preCheckCast(this.mAllowedExtras.get(r4), Predicate.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            r0 = $$Lambda$IntentSanitizer$Builder$JqtzG9U86Ag945qpBJ8rYic8JJ4.INSTANCE;
        L5:
            Predicate<Object> r7 = r0.or(r6);
            this.mAllowedExtras.put(r4, r7);
            return this;
        }

        public Builder allowExtra(String r2, Class<?> r3) {
            return allowExtra(r2, r3, $$Lambda$IntentSanitizer$Builder$eCvXo7KAaM8a9dmzzdotDaaREs8.INSTANCE);
        }

        public <T> Builder allowExtra(String r3, final Class<T> r4, Predicate<T> r5) {
            final Predicate r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r5, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r3);
            Preconditions.checkNotNull(r4);
            Preconditions.checkNotNull(r6);
            return allowExtra(r3, new $$Lambda$IntentSanitizer$Builder$mjBYkmM8ToC_lDxhzbaIvMBaWXI(r4, r6));
        }

        public Builder allowExtraOutput(Predicate<Uri> r3) {
            allowExtra("output", Uri.class, (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder allowExtraOutput(final String r3) {
            allowExtra("output", Uri.class, new $$Lambda$IntentSanitizer$Builder$Eddo0m3KohqNdvDITvaWLNd_s(r3));
            return this;
        }

        public Builder allowExtraStream(Predicate<Uri> r3) {
            allowExtra("android.intent.extra.STREAM", Uri.class, (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(final String r3) {
            Preconditions.checkNotNull(r3);
            allowExtra("android.intent.extra.STREAM", Uri.class, new $$Lambda$IntentSanitizer$Builder$hP04nFqyx8UqjzY2cMl4EYTQ4(r3));
            return this;
        }

        public Builder allowFlags(int r2) {
            this.mAllowedFlags = r2 | this.mAllowedFlags;
            return this;
        }

        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public Builder allowPackage(Predicate<String> r3) {
            Predicate<? super String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedPackages = this.mAllowedPackages.or(r4);
            return this;
        }

        public Builder allowPackage(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowPackage(new $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc(r2));
        }

        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public Builder allowType(Predicate<String> r3) {
            Predicate<? super String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4);
            this.mAllowedTypes = this.mAllowedTypes.or(r4);
            return this;
        }

        public Builder allowType(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowType(new $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc(r2));
        }

        public IntentSanitizer build() {
            boolean r0 = this.mAllowAnyComponent;
            if (r0 == true) goto L5;
        L6:
            if (r0 == false) goto L8;
        L12:
            IntentSanitizer r1 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r1, this.mAllowedFlags);
            IntentSanitizer.access$202(r1, this.mAllowedActions);
            IntentSanitizer.access$302(r1, this.mAllowedData);
            IntentSanitizer.access$402(r1, this.mAllowedTypes);
            IntentSanitizer.access$502(r1, this.mAllowedCategories);
            IntentSanitizer.access$602(r1, this.mAllowedPackages);
            IntentSanitizer.access$702(r1, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r1, this.mAllowedComponents);
            IntentSanitizer.access$902(r1, this.mAllowedExtras);
            IntentSanitizer.access$1002(r1, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r1, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r1, this.mAllowedClipData);
            IntentSanitizer.access$1302(r1, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r1, this.mAllowSelector);
            IntentSanitizer.access$1502(r1, this.mAllowSourceBounds);
            return r1;
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

    /* synthetic */ IntentSanitizer(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$1002(IntentSanitizer r0, boolean r1) {
        r0.mAllowClipDataText = r1;
        return r1;
    }

    static /* synthetic */ int access$102(IntentSanitizer r0, int r1) {
        r0.mAllowedFlags = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$1102(IntentSanitizer r2, Predicate r3) {
        Predicate<Uri> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedClipDataUri = r4;
        return r4;
    }

    static /* synthetic */ Predicate access$1202(IntentSanitizer r2, Predicate r3) {
        Predicate<ClipData> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedClipData = r4;
        return r4;
    }

    static /* synthetic */ boolean access$1302(IntentSanitizer r0, boolean r1) {
        r0.mAllowIdentifier = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1402(IntentSanitizer r0, boolean r1) {
        r0.mAllowSelector = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1502(IntentSanitizer r0, boolean r1) {
        r0.mAllowSourceBounds = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$202(IntentSanitizer r2, Predicate r3) {
        Predicate<String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedActions = r4;
        return r4;
    }

    static /* synthetic */ Predicate access$302(IntentSanitizer r2, Predicate r3) {
        Predicate<Uri> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedData = r4;
        return r4;
    }

    static /* synthetic */ Predicate access$402(IntentSanitizer r2, Predicate r3) {
        Predicate<String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedTypes = r4;
        return r4;
    }

    static /* synthetic */ Predicate access$502(IntentSanitizer r2, Predicate r3) {
        Predicate<String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedCategories = r4;
        return r4;
    }

    static /* synthetic */ Predicate access$602(IntentSanitizer r2, Predicate r3) {
        Predicate<String> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedPackages = r4;
        return r4;
    }

    static /* synthetic */ boolean access$702(IntentSanitizer r0, boolean r1) {
        r0.mAllowAnyComponent = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$802(IntentSanitizer r2, Predicate r3) {
        Predicate<ComponentName> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        r2.mAllowedComponents = r4;
        return r4;
    }

    static /* synthetic */ Map access$902(IntentSanitizer r2, Map r3) {
        Map<String, Predicate<Object>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r2.mAllowedExtras = r4;
        return r4;
    }

    static /* synthetic */ void lambda$sanitizeByFiltering$0(String r0) {
    }

    static /* synthetic */ void lambda$sanitizeByThrowing$1(String r1) {
        throw new SecurityException(r1);
    }

    private void putExtra(Intent r2, String r3, Object r4) {
        if (r4 != null) goto L5;
        r2.getExtras().putString(r3, null);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Parcelable.class) == false) goto L8;
        r2.putExtra(r3, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        if ((r4 instanceof Parcelable[]) == false) goto L11;
        r2.putExtra(r3, (Parcelable[]) ZeusTransformUtils.preCheckCast(r4, Parcelable[].class, "com.obric.memorydata.plugin"));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, Serializable.class) == false) goto L15;
        r2.putExtra(r3, (Serializable) ZeusTransformUtils.preCheckCast(r4, Serializable.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r4.getClass());
    }

    public Intent sanitize(Intent r9, Consumer<String> r10) {
        Consumer r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r10, Consumer.class, "com.obric.memorydata.plugin");
        Intent r0 = new Intent();
        ComponentName r2 = r9.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r2 != null) goto L6;
    L7:
        r0.setComponent(r2);
        String r3 = r9.getPackage();
        if (r3 != null) goto L12;
    L15:
        r0.setPackage(r3);
    L16:
        int r4 = this.mAllowedFlags | r9.getFlags();
        int r5 = this.mAllowedFlags;
        if (r4 != r5) goto L19;
        r0.setFlags(r9.getFlags());
    L20:
        String r6 = r9.getAction();
        if (r6 != null) goto L23;
    L26:
        r0.setAction(r6);
    L27:
        Uri r7 = r9.getData();
        if (r7 != null) goto L30;
    L33:
        r0.setData(r7);
    L34:
        String r8 = r9.getType();
        if (r8 != null) goto L37;
    L40:
        r0.setDataAndType(r0.getData(), r8);
    L41:
        Set<String> r12 = r9.getCategories();
        if (r12 == null) goto L50;
        Iterator<String> r13 = r12.iterator();
    L45:
        if (r13.hasNext() == false) goto L50;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mAllowedCategories.test(r14) == true) goto L48;
        r11.accept("Category is not allowed: " + r14);
        goto L45
    L48:
        r0.addCategory(r14);
    L50:
        Bundle r15 = r9.getExtras();
        if (r15 == null) goto L73;
        Iterator<String> r16 = r15.keySet().iterator();
    L54:
        if (r16.hasNext() == false) goto L73;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r17.equals("android.intent.extra.STREAM") == false) goto L62;
        if ((this.mAllowedFlags & 1) != 0) goto L62;
        String r18 = "Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.";
    L60:
        r11.accept(r18);
    L62:
        if (r17.equals("output") == true) goto L64;
    L66:
        Object r19 = r15.get(r17);
        Predicate r20 = (Predicate) ZeusTransformUtils.preCheckCast(this.mAllowedExtras.get(r17), Predicate.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L71;
        if (r20.test(r19) == false) goto L71;
        putExtra(r0, r17, r19);
    L71:
        r18 = "Extra is not allowed. Key: " + r17 + ". Value: " + r19;
        goto L60
    L64:
        if (((~this.mAllowedFlags) & 3) == 0) goto L66;
        r18 = "Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.";
    L73:
        if (Build.VERSION.SDK_INT < 16) goto L76;
        Api16Impl.sanitizeClipData(r9, r0, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r11);
    L76:
        if (Build.VERSION.SDK_INT < 29) goto L84;
        if (this.mAllowIdentifier == false) goto L81;
        Api29Impl.setIdentifier(r0, Api29Impl.getIdentifier(r9));
        goto L84
    L81:
        if (Api29Impl.getIdentifier(r9) == null) goto L84;
        r11.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r9));
    L84:
        if (Build.VERSION.SDK_INT < 15) goto L92;
        if (this.mAllowSelector == false) goto L89;
        Api15Impl.setSelector(r0, Api15Impl.getSelector(r9));
        goto L92
    L89:
        if (Api15Impl.getSelector(r9) == null) goto L92;
        r11.accept("Selector is not allowed: " + Api15Impl.getSelector(r9));
    L92:
        if (this.mAllowSourceBounds == false) goto L95;
        r0.setSourceBounds(r9.getSourceBounds());
    L97:
        return r0;
    L95:
        if (r9.getSourceBounds() == null) goto L97;
        r11.accept("SourceBounds is not allowed: " + r9.getSourceBounds());
        goto L97
    L37:
        if (this.mAllowedTypes.test(r8) == true) goto L40;
        r11.accept("Type is not allowed: " + r8);
        goto L41
    L30:
        if (this.mAllowedData.test(r7) == true) goto L33;
        r11.accept("Data is not allowed: " + r7);
        goto L34
    L23:
        if (this.mAllowedActions.test(r6) == true) goto L26;
        r11.accept("Action is not allowed: " + r6);
        goto L27
    L19:
        r0.setFlags(r9.getFlags() & r5);
        r11.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r9.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r3) == true) goto L15;
        r11.accept("Package is not allowed: " + r3);
    L6:
        if (this.mAllowedComponents.test(r2) == true) goto L7;
        r11.accept("Component is not allowed: " + r2);
        r2 = new ComponentName("android", "java.lang.Void");
        goto L7
    }

    public Intent sanitizeByFiltering(Intent r2) {
        return sanitize(r2, $$Lambda$IntentSanitizer$cs9npxBvv_qtzxpDgSnPy7MmurY.INSTANCE);
    }

    public Intent sanitizeByThrowing(Intent r2) {
        return sanitize(r2, $$Lambda$IntentSanitizer$NofwxHOZrEEV1MRTpUn9ROuxIY8.INSTANCE);
    }
}
