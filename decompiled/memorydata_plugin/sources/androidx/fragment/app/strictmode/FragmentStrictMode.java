package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003./0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0002J0\u0010*\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0,2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00061"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "()V", "TAG", "", "defaultPolicy", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "getNearestPolicy", "fragment", "Landroidx/fragment/app/Fragment;", "handlePolicyViolation", "", "policy", "violation", "Landroidx/fragment/app/strictmode/Violation;", "logIfDebuggingEnabled", "onFragmentReuse", "previousFragmentId", "onFragmentTagUsage", "container", "Landroid/view/ViewGroup;", "onGetRetainInstanceUsage", "onGetTargetFragmentRequestCodeUsage", "onGetTargetFragmentUsage", "onPolicyViolation", "onSetRetainInstanceUsage", "onSetTargetFragmentUsage", "violatingFragment", "targetFragment", "requestCode", "", "onSetUserVisibleHint", "isVisibleToUser", "", "onWrongFragmentContainer", "runOnHostThread", "runnable", "Ljava/lang/Runnable;", "shouldHandlePolicyViolation", "fragmentClass", "Ljava/lang/Class;", "violationClass", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = null;
    private static final String TAG = "FragmentStrictMode";
    private static Policy defaultPolicy;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Flag extends Enum<Flag> {
        private static final /* synthetic */ Flag[] $VALUES = null;
        public static final Flag DETECT_FRAGMENT_REUSE = null;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE = null;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE = null;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT = null;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE = null;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER = null;
        public static final Flag PENALTY_DEATH = null;
        public static final Flag PENALTY_LOG = null;

        private static final /* synthetic */ Flag[] $values() {
            return new Flag[]{PENALTY_LOG, PENALTY_DEATH, DETECT_FRAGMENT_REUSE, DETECT_FRAGMENT_TAG_USAGE, DETECT_RETAIN_INSTANCE_USAGE, DETECT_SET_USER_VISIBLE_HINT, DETECT_TARGET_FRAGMENT_USAGE, DETECT_WRONG_FRAGMENT_CONTAINER};
        }

        static {
            PENALTY_LOG = new Flag("PENALTY_LOG", 0);
            PENALTY_DEATH = new Flag("PENALTY_DEATH", 1);
            DETECT_FRAGMENT_REUSE = new Flag("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_TAG_USAGE = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_RETAIN_INSTANCE_USAGE = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 4);
            DETECT_SET_USER_VISIBLE_HINT = new Flag("DETECT_SET_USER_VISIBLE_HINT", 5);
            DETECT_TARGET_FRAGMENT_USAGE = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 6);
            DETECT_WRONG_FRAGMENT_CONTAINER = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
            $VALUES = $values();
        }

        private Flag(String r1, int r2) {
            super(r1, r2);
        }

        public static Flag valueOf(String r2) {
            return (Flag) ZeusTransformUtils.preCheckCast(Enum.valueOf(Flag.class, r2), Flag.class, "com.obric.memorydata.plugin");
        }

        public static Flag[] values() {
            return (Flag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Flag[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnViolationListener {
        void onViolation(Violation r1);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\b¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00030\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "allowedViolations", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "getFlags$fragment_release", "()Ljava/util/Set;", "getListener$fragment_release", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "getMAllowedViolations$fragment_release", "()Ljava/util/Map;", "Builder", "Companion", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Policy {
        public static final Companion Companion = null;
        public static final Policy LAX = null;
        private final Set<Flag> flags;
        private final OnViolationListener listener;
        private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\b\u0010\u0019\u001a\u00020\u0000H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u0000H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "()V", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowViolation", "fragmentClass", "Landroidx/fragment/app/Fragment;", "violationClass", "build", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "detectFragmentReuse", "detectFragmentTagUsage", "detectRetainInstanceUsage", "detectSetUserVisibleHint", "detectTargetFragmentUsage", "detectWrongFragmentContainer", "penaltyDeath", "penaltyListener", "penaltyLog", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private final Set<Flag> flags;
            private OnViolationListener listener;
            private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

            public Builder() {
                this.flags = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
                this.mAllowedViolations = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            }

            public final Builder allowViolation(Class<? extends Fragment> r2, Class<? extends Violation> r3) {
                Intrinsics.checkNotNullParameter(r2, "fragmentClass");
                Intrinsics.checkNotNullParameter(r3, "violationClass");
                String r4 = r2.getName();
                Intrinsics.checkNotNullExpressionValue(r4, "fragmentClassString");
                return allowViolation(r4, r3);
            }

            public final Builder allowViolation(String r4, Class<? extends Violation> r5) {
                Intrinsics.checkNotNullParameter(r4, "fragmentClass");
                Intrinsics.checkNotNullParameter(r5, "violationClass");
                Set<Class<? extends Violation>> r0 = (Set) ZeusTransformUtils.preCheckCast(this.mAllowedViolations.get(r4), Set.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L5;
                r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            L5:
                r0.add(r5);
                this.mAllowedViolations.put(r4, r0);
                return this;
            }

            public final Policy build() {
                if (this.listener != null) goto L8;
                if (this.flags.contains(Flag.PENALTY_DEATH) == true) goto L8;
                penaltyLog();
            L8:
                return new Policy(this.flags, this.listener, this.mAllowedViolations);
            }

            public final Builder detectFragmentReuse() {
                this.flags.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            public final Builder detectFragmentTagUsage() {
                this.flags.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            public final Builder detectRetainInstanceUsage() {
                this.flags.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            public final Builder detectSetUserVisibleHint() {
                this.flags.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            public final Builder detectTargetFragmentUsage() {
                this.flags.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            public final Builder detectWrongFragmentContainer() {
                this.flags.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            public final Builder penaltyDeath() {
                this.flags.add(Flag.PENALTY_DEATH);
                return this;
            }

            public final Builder penaltyListener(OnViolationListener r3) {
                OnViolationListener r4 = (OnViolationListener) ZeusTransformUtils.wrapperContextForParams(r3, OnViolationListener.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "listener");
                this.listener = r4;
                return this;
            }

            public final Builder penaltyLog() {
                this.flags.add(Flag.PENALTY_LOG);
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            LAX = new Policy(SetsKt.emptySet(), null, MapsKt.emptyMap());
        }

        public Policy(Set<? extends Flag> r4, OnViolationListener r5, Map<String, ? extends Set<Class<? extends Violation>>> r6) {
            Set<Flag> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            OnViolationListener r8 = (OnViolationListener) ZeusTransformUtils.wrapperContextForParams(r5, OnViolationListener.class, "com.obric.memorydata.plugin");
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "flags");
            Intrinsics.checkNotNullParameter(r9, "allowedViolations");
            this.flags = r7;
            this.listener = r8;
            Map<String, Set<Class<? extends Violation>>> r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r11 = r9.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r10.put((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r12.getValue(), Set.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            this.mAllowedViolations = r10;
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

    private final Policy getNearestPolicy(Fragment r2) {
    L2:
        if (r2 == null) goto L11;
        if (r2.isAdded() == false) goto L9;
        FragmentManager r1 = r2.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r1, "declaringFragment.parentFragmentManager");
        if (r1.getStrictModePolicy() == null) goto L9;
        Policy r3 = r1.getStrictModePolicy();
        Intrinsics.checkNotNull(r3);
        return r3;
    L9:
        r2 = r2.getParentFragment();
        goto L2
    L11:
        return defaultPolicy;
    }

    private final void handlePolicyViolation(final Policy r6, final Violation r7) {
        Fragment r0 = r7.getFragment();
        final String r1 = r0.getClass().getName();
        if (r6.getFlags$fragment_release().contains(Flag.PENALTY_LOG) == false) goto L6;
        Log.d(TAG, "Policy violation in " + r1, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        if (r6.getListener$fragment_release() == null) goto L9;
        runOnHostThread(r0, new $$Lambda$FragmentStrictMode$3GEKar9k4mm28McDHOXTHzF5lU(r6, r7));
    L9:
        if (r6.getFlags$fragment_release().contains(Flag.PENALTY_DEATH) == false) goto L12;
        runOnHostThread(r0, new $$Lambda$FragmentStrictMode$ujbeN2H_kHMJp2XfgBvtZfltiz0(r1, r7));
        return;
    }

    /* JADX INFO: renamed from: handlePolicyViolation$lambda-0, reason: not valid java name */
    private static final void m43handlePolicyViolation$lambda0(Policy r1, Violation r2) {
        Intrinsics.checkNotNullParameter(r1, "$policy");
        Intrinsics.checkNotNullParameter(r2, "$violation");
        r1.getListener$fragment_release().onViolation(r2);
    }

    /* JADX INFO: renamed from: handlePolicyViolation$lambda-1, reason: not valid java name */
    private static final void m44handlePolicyViolation$lambda1(String r2, Violation r3) {
        Intrinsics.checkNotNullParameter(r3, "$violation");
        Log.e(TAG, "Policy violation with PENALTY_DEATH in " + r2, (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        throw r3;
    }

    /* JADX INFO: renamed from: lambda$3GEKar9k4mm28McDHO-XTHzF5lU, reason: not valid java name */
    public static /* synthetic */ void m45lambda$3GEKar9k4mm28McDHOXTHzF5lU(Policy r0, Violation r1) {
        m43handlePolicyViolation$lambda0(r0, r1);
    }

    public static /* synthetic */ void lambda$ujbeN2H_kHMJp2XfgBvtZfltiz0(String r0, Violation r1) {
        m44handlePolicyViolation$lambda1(r0, r1);
    }

    private final void logIfDebuggingEnabled(Violation r3) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "StrictMode violation in " + r3.getFragment().getClass().getName(), (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onFragmentReuse(Fragment r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "previousFragmentId");
        Violation r6 = (Violation) ZeusTransformUtils.preCheckCast(new FragmentReuseViolation(r4, r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r0 = INSTANCE;
        r0.logIfDebuggingEnabled(r6);
        Policy r1 = r0.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) == true) goto L5;
        return;
    L5:
        if (r0.shouldHandlePolicyViolation(r1, r4.getClass(), r6.getClass()) == false) goto L9;
        r0.handlePolicyViolation(r1, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onFragmentTagUsage(Fragment r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Violation r6 = (Violation) ZeusTransformUtils.preCheckCast(new FragmentTagUsageViolation(r4, r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r0 = INSTANCE;
        r0.logIfDebuggingEnabled(r6);
        Policy r1 = r0.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) == true) goto L5;
        return;
    L5:
        if (r0.shouldHandlePolicyViolation(r1, r4.getClass(), r6.getClass()) == false) goto L9;
        r0.handlePolicyViolation(r1, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onGetRetainInstanceUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Violation r0 = (Violation) ZeusTransformUtils.preCheckCast(new GetRetainInstanceUsageViolation(r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onGetTargetFragmentRequestCodeUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Violation r0 = (Violation) ZeusTransformUtils.preCheckCast(new GetTargetFragmentRequestCodeUsageViolation(r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onGetTargetFragmentUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Violation r0 = (Violation) ZeusTransformUtils.preCheckCast(new GetTargetFragmentUsageViolation(r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onSetRetainInstanceUsage(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Violation r0 = (Violation) ZeusTransformUtils.preCheckCast(new SetRetainInstanceUsageViolation(r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onSetTargetFragmentUsage(Fragment r3, Fragment r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "violatingFragment");
        Intrinsics.checkNotNullParameter(r4, "targetFragment");
        Violation r6 = (Violation) ZeusTransformUtils.preCheckCast(new SetTargetFragmentUsageViolation(r3, r4, r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r7 = INSTANCE;
        r7.logIfDebuggingEnabled(r6);
        Policy r0 = r7.getNearestPolicy(r3);
        if (r0.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r7.shouldHandlePolicyViolation(r0, r3.getClass(), r6.getClass()) == false) goto L9;
        r7.handlePolicyViolation(r0, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onSetUserVisibleHint(Fragment r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Violation r6 = (Violation) ZeusTransformUtils.preCheckCast(new SetUserVisibleHintViolation(r4, r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r0 = INSTANCE;
        r0.logIfDebuggingEnabled(r6);
        Policy r1 = r0.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) == true) goto L5;
        return;
    L5:
        if (r0.shouldHandlePolicyViolation(r1, r4.getClass(), r6.getClass()) == false) goto L9;
        r0.handlePolicyViolation(r1, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void onWrongFragmentContainer(Fragment r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "container");
        Violation r6 = (Violation) ZeusTransformUtils.preCheckCast(new WrongFragmentContainerViolation(r4, r5), Violation.class, "com.obric.memorydata.plugin");
        FragmentStrictMode r0 = INSTANCE;
        r0.logIfDebuggingEnabled(r6);
        Policy r1 = r0.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) == true) goto L5;
        return;
    L5:
        if (r0.shouldHandlePolicyViolation(r1, r4.getClass(), r6.getClass()) == false) goto L9;
        r0.handlePolicyViolation(r1, r6);
        return;
    }

    private final void runOnHostThread(Fragment r2, Runnable r3) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r2.isAdded() == false) goto L8;
        Handler r4 = r2.getParentFragmentManager().getHost().getHandler();
        Intrinsics.checkNotNullExpressionValue(r4, "fragment.parentFragmentManager.host.handler");
        if (Intrinsics.areEqual(r4.getLooper(), Looper.myLooper()) == true) goto L8;
        r4.post(r1);
        return;
    L8:
        r1.run();
    }

    private final boolean shouldHandlePolicyViolation(Policy r3, Class<? extends Fragment> r4, Class<? extends Violation> r5) {
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(r3.getMAllowedViolations$fragment_release().get(r4.getName()), Set.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5.getSuperclass(), Violation.class) == true) goto L12;
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), r5.getSuperclass()) == false) goto L12;
        return false;
    L12:
        return !r2.contains(r5);
    }

    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPolicyViolation(Violation r4) {
        Intrinsics.checkNotNullParameter(r4, "violation");
        logIfDebuggingEnabled(r4);
        Fragment r0 = r4.getFragment();
        Policy r1 = getNearestPolicy(r0);
        if (shouldHandlePolicyViolation(r1, r0.getClass(), r4.getClass()) == false) goto L6;
        handlePolicyViolation(r1, r4);
        return;
    }

    public final void setDefaultPolicy(Policy r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        defaultPolicy = r1;
    }
}
