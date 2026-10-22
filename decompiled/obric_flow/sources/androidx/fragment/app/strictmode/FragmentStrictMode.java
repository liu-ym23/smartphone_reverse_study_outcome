package androidx.fragment.app.strictmode;

import a2.b;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003123B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010'\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\"H\u0007J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0002J0\u0010-\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0/2\u000e\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120/H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00064"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "()V", "TAG", "", "defaultPolicy", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "getNearestPolicy", "fragment", "Landroidx/fragment/app/Fragment;", "handlePolicyViolation", "", "policy", "violation", "Landroidx/fragment/app/strictmode/Violation;", "logIfDebuggingEnabled", "onFragmentReuse", "previousFragmentId", "onFragmentTagUsage", "container", "Landroid/view/ViewGroup;", "onGetRetainInstanceUsage", "onGetTargetFragmentRequestCodeUsage", "onGetTargetFragmentUsage", "onPolicyViolation", "onSetRetainInstanceUsage", "onSetTargetFragmentUsage", "violatingFragment", "targetFragment", "requestCode", "", "onSetUserVisibleHint", "isVisibleToUser", "", "onWrongFragmentContainer", "onWrongNestedHierarchy", "expectedParentFragment", "containerId", "runOnHostThread", "runnable", "Ljava/lang/Runnable;", "shouldHandlePolicyViolation", "fragmentClass", "Ljava/lang/Class;", "violationClass", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = null;
    private static final String TAG = "FragmentStrictMode";
    private static Policy defaultPolicy;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_WRONG_NESTED_HIERARCHY", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Flag extends Enum<Flag> {
        private static final /* synthetic */ Flag[] $VALUES = null;
        public static final Flag DETECT_FRAGMENT_REUSE = null;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE = null;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE = null;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT = null;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE = null;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER = null;
        public static final Flag DETECT_WRONG_NESTED_HIERARCHY = null;
        public static final Flag PENALTY_DEATH = null;
        public static final Flag PENALTY_LOG = null;

        private static final /* synthetic */ Flag[] $values() {
            return new Flag[]{PENALTY_LOG, PENALTY_DEATH, DETECT_FRAGMENT_REUSE, DETECT_FRAGMENT_TAG_USAGE, DETECT_WRONG_NESTED_HIERARCHY, DETECT_RETAIN_INSTANCE_USAGE, DETECT_SET_USER_VISIBLE_HINT, DETECT_TARGET_FRAGMENT_USAGE, DETECT_WRONG_FRAGMENT_CONTAINER};
        }

        static {
            PENALTY_LOG = new Flag("PENALTY_LOG", 0);
            PENALTY_DEATH = new Flag("PENALTY_DEATH", 1);
            DETECT_FRAGMENT_REUSE = new Flag("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_TAG_USAGE = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_WRONG_NESTED_HIERARCHY = new Flag("DETECT_WRONG_NESTED_HIERARCHY", 4);
            DETECT_RETAIN_INSTANCE_USAGE = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 5);
            DETECT_SET_USER_VISIBLE_HINT = new Flag("DETECT_SET_USER_VISIBLE_HINT", 6);
            DETECT_TARGET_FRAGMENT_USAGE = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 7);
            DETECT_WRONG_FRAGMENT_CONTAINER = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
            $VALUES = $values();
        }

        private Flag(String r5, int r10) {
            super(r5, r10);
        }

        public static Flag valueOf(String r5) {
            return (Flag) Enum.valueOf(Flag.class, r5);
        }

        public static Flag[] values() {
            return (Flag[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnViolationListener {
        void onViolation(Violation r5);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\b¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00030\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "allowedViolations", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "getFlags$fragment_release", "()Ljava/util/Set;", "getListener$fragment_release", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "getMAllowedViolations$fragment_release", "()Ljava/util/Map;", "Builder", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Policy {
        public static final Companion Companion = null;

        @JvmField
        public static final Policy LAX = null;
        private final Set<Flag> flags;
        private final OnViolationListener listener;
        private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\b\u0010\u0019\u001a\u00020\u0000H\u0007J\b\u0010\u001a\u001a\u00020\u0000H\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\u001c\u001a\u00020\u0000H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "()V", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowViolation", "fragmentClass", "Landroidx/fragment/app/Fragment;", "violationClass", "build", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "detectFragmentReuse", "detectFragmentTagUsage", "detectRetainInstanceUsage", "detectSetUserVisibleHint", "detectTargetFragmentUsage", "detectWrongFragmentContainer", "detectWrongNestedHierarchy", "penaltyDeath", "penaltyListener", "penaltyLog", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Builder {
            private final Set<Flag> flags;
            private OnViolationListener listener;
            private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

            public Builder() {
                this.flags = new LinkedHashSet();
                this.mAllowedViolations = new LinkedHashMap();
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(Class<? extends Fragment> r5, Class<? extends Violation> r10) {
                Intrinsics.checkNotNullParameter(r5, "fragmentClass");
                Intrinsics.checkNotNullParameter(r10, "violationClass");
                return allowViolation(r5.getName(), r10);
            }

            public final Policy build() {
                if (this.listener != null) goto L8;
                if (this.flags.contains(Flag.PENALTY_DEATH) == true) goto L8;
                penaltyLog();
            L8:
                return new Policy(this.flags, this.listener, this.mAllowedViolations);
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentReuse() {
                this.flags.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentTagUsage() {
                this.flags.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectRetainInstanceUsage() {
                this.flags.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectSetUserVisibleHint() {
                this.flags.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectTargetFragmentUsage() {
                this.flags.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectWrongFragmentContainer() {
                this.flags.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectWrongNestedHierarchy() {
                this.flags.add(Flag.DETECT_WRONG_NESTED_HIERARCHY);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyDeath() {
                this.flags.add(Flag.PENALTY_DEATH);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyListener(OnViolationListener r5) {
                Intrinsics.checkNotNullParameter(r5, "listener");
                this.listener = r5;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyLog() {
                this.flags.add(Flag.PENALTY_LOG);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(String r5, Class<? extends Violation> r10) {
                Intrinsics.checkNotNullParameter(r5, "fragmentClass");
                Intrinsics.checkNotNullParameter(r10, "violationClass");
                Set<Class<? extends Violation>> r11 = this.mAllowedViolations.get(r5);
                if (r11 != null) goto L5;
                r11 = new LinkedHashSet();
            L5:
                r11.add(r10);
                this.mAllowedViolations.put(r5, r11);
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            LAX = new Policy(SetsKt.emptySet(), null, MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Policy(Set<? extends Flag> r5, OnViolationListener r10, Map<String, ? extends Set<Class<? extends Violation>>> r11) {
            Intrinsics.checkNotNullParameter(r5, "flags");
            Intrinsics.checkNotNullParameter(r11, "allowedViolations");
            this.flags = r5;
            this.listener = r10;
            LinkedHashMap r12 = new LinkedHashMap();
            Iterator<Map.Entry<String, ? extends Set<Class<? extends Violation>>>> r13 = r11.entrySet().iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            Map.Entry<String, ? extends Set<Class<? extends Violation>>> r14 = r13.next();
            r12.put(r14.getKey(), r14.getValue());
            goto L4
        L6:
            this.mAllowedViolations = r12;
        }

        public final Set<Flag> getFlags$fragment_release() {
            return this.flags;
        }

        public final OnViolationListener getListener$fragment_release() {
            return this.listener;
        }

        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.mAllowedViolations;
        }
    }

    static {
        INSTANCE = new FragmentStrictMode();
        defaultPolicy = Policy.LAX;
    }

    private FragmentStrictMode() {
    }

    public static /* synthetic */ void a(String r5, Violation r10) {
        handlePolicyViolation$lambda$1(r5, r10);
    }

    public static /* synthetic */ void b(Policy r5, Violation r10) {
        handlePolicyViolation$lambda$0(r5, r10);
    }

    private final Policy getNearestPolicy(Fragment r5) {
    L2:
        if (r5 == null) goto L11;
        if (r5.isAdded() == false) goto L9;
        FragmentManager r10 = r5.getParentFragmentManager();
        if (r10.getStrictModePolicy() == null) goto L9;
        Policy r11 = r10.getStrictModePolicy();
        Intrinsics.checkNotNull(r11);
        return r11;
    L9:
        r5 = r5.getParentFragment();
        goto L2
    L11:
        return defaultPolicy;
    }

    private final void handlePolicyViolation(Policy r5, Violation r10) {
        Fragment r11 = r10.getFragment();
        String r12 = r11.getClass().getName();
        if (r5.getFlags$fragment_release().contains(Flag.PENALTY_LOG) == false) goto L6;
        Log.d(TAG, "Policy violation in ".concat(r12), r10);
    L6:
        if (r5.getListener$fragment_release() == null) goto L9;
        runOnHostThread(r11, new b(18, r5, r10));
    L9:
        if (r5.getFlags$fragment_release().contains(Flag.PENALTY_DEATH) == false) goto L12;
        runOnHostThread(r11, new b(19, r12, r10));
        return;
    }

    private static final void handlePolicyViolation$lambda$0(Policy r5, Violation r10) {
        Intrinsics.checkNotNullParameter(r5, "$policy");
        Intrinsics.checkNotNullParameter(r10, "$violation");
        r5.getListener$fragment_release().onViolation(r10);
    }

    private static final void handlePolicyViolation$lambda$1(String r5, Violation r10) {
        Intrinsics.checkNotNullParameter(r10, "$violation");
        Log.e(TAG, "Policy violation with PENALTY_DEATH in " + r5, r10);
        throw r10;
    }

    private final void logIfDebuggingEnabled(Violation r5) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "StrictMode violation in ".concat(r5.getFragment().getClass().getName()), r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentReuse(Fragment r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r10, "previousFragmentId");
        FragmentReuseViolation r11 = new FragmentReuseViolation(r5, r10);
        FragmentStrictMode r12 = INSTANCE;
        r12.logIfDebuggingEnabled(r11);
        Policy r13 = r12.getNearestPolicy(r5);
        if (r13.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) == true) goto L5;
        return;
    L5:
        if (r12.shouldHandlePolicyViolation(r13, r5.getClass(), r11.getClass()) == false) goto L9;
        r12.handlePolicyViolation(r13, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentTagUsage(Fragment r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        FragmentTagUsageViolation r11 = new FragmentTagUsageViolation(r5, r10);
        FragmentStrictMode r12 = INSTANCE;
        r12.logIfDebuggingEnabled(r11);
        Policy r13 = r12.getNearestPolicy(r5);
        if (r13.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) == true) goto L5;
        return;
    L5:
        if (r12.shouldHandlePolicyViolation(r13, r5.getClass(), r11.getClass()) == false) goto L9;
        r12.handlePolicyViolation(r13, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetRetainInstanceUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        GetRetainInstanceUsageViolation r10 = new GetRetainInstanceUsageViolation(r5);
        FragmentStrictMode r11 = INSTANCE;
        r11.logIfDebuggingEnabled(r10);
        Policy r12 = r11.getNearestPolicy(r5);
        if (r12.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r11.shouldHandlePolicyViolation(r12, r5.getClass(), r10.getClass()) == false) goto L9;
        r11.handlePolicyViolation(r12, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentRequestCodeUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        GetTargetFragmentRequestCodeUsageViolation r10 = new GetTargetFragmentRequestCodeUsageViolation(r5);
        FragmentStrictMode r11 = INSTANCE;
        r11.logIfDebuggingEnabled(r10);
        Policy r12 = r11.getNearestPolicy(r5);
        if (r12.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r11.shouldHandlePolicyViolation(r12, r5.getClass(), r10.getClass()) == false) goto L9;
        r11.handlePolicyViolation(r12, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        GetTargetFragmentUsageViolation r10 = new GetTargetFragmentUsageViolation(r5);
        FragmentStrictMode r11 = INSTANCE;
        r11.logIfDebuggingEnabled(r10);
        Policy r12 = r11.getNearestPolicy(r5);
        if (r12.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r11.shouldHandlePolicyViolation(r12, r5.getClass(), r10.getClass()) == false) goto L9;
        r11.handlePolicyViolation(r12, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetRetainInstanceUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        SetRetainInstanceUsageViolation r10 = new SetRetainInstanceUsageViolation(r5);
        FragmentStrictMode r11 = INSTANCE;
        r11.logIfDebuggingEnabled(r10);
        Policy r12 = r11.getNearestPolicy(r5);
        if (r12.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r11.shouldHandlePolicyViolation(r12, r5.getClass(), r10.getClass()) == false) goto L9;
        r11.handlePolicyViolation(r12, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetTargetFragmentUsage(Fragment r5, Fragment r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "violatingFragment");
        Intrinsics.checkNotNullParameter(r10, "targetFragment");
        SetTargetFragmentUsageViolation r12 = new SetTargetFragmentUsageViolation(r5, r10, r11);
        FragmentStrictMode r13 = INSTANCE;
        r13.logIfDebuggingEnabled(r12);
        Policy r14 = r13.getNearestPolicy(r5);
        if (r14.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r13.shouldHandlePolicyViolation(r14, r5.getClass(), r12.getClass()) == false) goto L9;
        r13.handlePolicyViolation(r14, r12);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetUserVisibleHint(Fragment r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        SetUserVisibleHintViolation r11 = new SetUserVisibleHintViolation(r5, r10);
        FragmentStrictMode r12 = INSTANCE;
        r12.logIfDebuggingEnabled(r11);
        Policy r13 = r12.getNearestPolicy(r5);
        if (r13.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) == true) goto L5;
        return;
    L5:
        if (r12.shouldHandlePolicyViolation(r13, r5.getClass(), r11.getClass()) == false) goto L9;
        r12.handlePolicyViolation(r13, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongFragmentContainer(Fragment r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r10, "container");
        WrongFragmentContainerViolation r11 = new WrongFragmentContainerViolation(r5, r10);
        FragmentStrictMode r12 = INSTANCE;
        r12.logIfDebuggingEnabled(r11);
        Policy r13 = r12.getNearestPolicy(r5);
        if (r13.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) == true) goto L5;
        return;
    L5:
        if (r12.shouldHandlePolicyViolation(r13, r5.getClass(), r11.getClass()) == false) goto L9;
        r12.handlePolicyViolation(r13, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongNestedHierarchy(Fragment r5, Fragment r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r10, "expectedParentFragment");
        WrongNestedHierarchyViolation r12 = new WrongNestedHierarchyViolation(r5, r10, r11);
        FragmentStrictMode r13 = INSTANCE;
        r13.logIfDebuggingEnabled(r12);
        Policy r14 = r13.getNearestPolicy(r5);
        if (r14.getFlags$fragment_release().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) == true) goto L5;
        return;
    L5:
        if (r13.shouldHandlePolicyViolation(r14, r5.getClass(), r12.getClass()) == false) goto L9;
        r13.handlePolicyViolation(r14, r12);
        return;
    }

    private final void runOnHostThread(Fragment r5, Runnable r10) {
        if (r5.isAdded() == false) goto L8;
        Handler r11 = r5.getParentFragmentManager().getHost().getHandler();
        if (Intrinsics.areEqual(r11.getLooper(), Looper.myLooper()) == false) goto L7;
        r10.run();
        return;
    L7:
        r11.post(r10);
        return;
    L8:
        r10.run();
    }

    private final boolean shouldHandlePolicyViolation(Policy r5, Class<? extends Fragment> r10, Class<? extends Violation> r11) {
        Set<Class<? extends Violation>> r12 = r5.getMAllowedViolations$fragment_release().get(r10.getName());
        if (r12 != null) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r11.getSuperclass(), Violation.class) == true) goto L12;
        if (CollectionsKt.contains(r12, r11.getSuperclass()) == false) goto L12;
        return false;
    L12:
        return !r12.contains(r11);
    }

    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public final void onPolicyViolation(Violation r5) {
        Intrinsics.checkNotNullParameter(r5, "violation");
        logIfDebuggingEnabled(r5);
        Fragment r10 = r5.getFragment();
        Policy r11 = getNearestPolicy(r10);
        if (shouldHandlePolicyViolation(r11, r10.getClass(), r5.getClass()) == false) goto L6;
        handlePolicyViolation(r11, r5);
        return;
    }

    public final void setDefaultPolicy(Policy r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        defaultPolicy = r5;
    }
}
