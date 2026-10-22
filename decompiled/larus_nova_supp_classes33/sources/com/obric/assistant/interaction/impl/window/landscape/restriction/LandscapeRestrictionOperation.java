package com.obric.assistant.interaction.impl.window.landscape.restriction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName$impl_mainlandRelease", "()Ljava/lang/String;", "DIALOG_SHOW", "DIALOG_FRAGMENT_SHOW", "DIALOG_FRAGMENT_SHOW_NOW", "DIALOG_FRAGMENT_SHOW_TRANSACTION", "FRAGMENT_TRANSACTION_ADD", "FRAGMENT_TRANSACTION_REPLACE", "UNKNOWN", "isDialogFragmentShowOperation", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LandscapeRestrictionOperation extends Enum<LandscapeRestrictionOperation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LandscapeRestrictionOperation[] $VALUES = null;
    public static final Companion Companion = null;
    public static final LandscapeRestrictionOperation DIALOG_FRAGMENT_SHOW = null;
    public static final LandscapeRestrictionOperation DIALOG_FRAGMENT_SHOW_NOW = null;
    public static final LandscapeRestrictionOperation DIALOG_FRAGMENT_SHOW_TRANSACTION = null;
    public static final LandscapeRestrictionOperation DIALOG_SHOW = null;
    public static final LandscapeRestrictionOperation FRAGMENT_TRANSACTION_ADD = null;
    public static final LandscapeRestrictionOperation FRAGMENT_TRANSACTION_REPLACE = null;
    private static final String LEGACY_ADD_PREFIX = "add(";
    private static final String LEGACY_DIALOG_FRAGMENT_SHOW = "dialogFragment.show";
    private static final String LEGACY_DIALOG_FRAGMENT_SHOW_NOW = "dialogFragment.showNow";
    private static final String LEGACY_DIALOG_FRAGMENT_SHOW_TRANSACTION = "dialogFragment.show(transaction)";
    private static final String LEGACY_DIALOG_SHOW = "dialog.show";
    private static final String LEGACY_REPLACE_PREFIX = "replace(";
    public static final LandscapeRestrictionOperation UNKNOWN = null;
    private final String traceName;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation$Companion;", "", "<init>", "()V", "LEGACY_DIALOG_SHOW", "", "LEGACY_DIALOG_FRAGMENT_SHOW", "LEGACY_DIALOG_FRAGMENT_SHOW_NOW", "LEGACY_DIALOG_FRAGMENT_SHOW_TRANSACTION", "LEGACY_ADD_PREFIX", "LEGACY_REPLACE_PREFIX", "fromLegacyName", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "operation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final LandscapeRestrictionOperation fromLegacyName(String r6) {
            if (Intrinsics.areEqual(r6, LandscapeRestrictionOperation.LEGACY_DIALOG_SHOW) == false) goto L6;
            return LandscapeRestrictionOperation.DIALOG_SHOW;
        L6:
            if (Intrinsics.areEqual(r6, LandscapeRestrictionOperation.LEGACY_DIALOG_FRAGMENT_SHOW) == false) goto L9;
            return LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        L9:
            if (Intrinsics.areEqual(r6, LandscapeRestrictionOperation.LEGACY_DIALOG_FRAGMENT_SHOW_NOW) == false) goto L12;
            return LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        L12:
            if (Intrinsics.areEqual(r6, LandscapeRestrictionOperation.LEGACY_DIALOG_FRAGMENT_SHOW_TRANSACTION) == true) goto L34;
            boolean r2 = true;
            if (r6 != null) goto L17;
        L19:
            boolean r4 = false;
        L20:
            if (r4 == true) goto L35;
            if (r6 != null) goto L24;
        L26:
            r2 = false;
        L27:
            if (r2 == false) goto L30;
            return LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE;
        L30:
            return LandscapeRestrictionOperation.UNKNOWN;
        L24:
            if (StringsKt.startsWith$default(r6, LandscapeRestrictionOperation.LEGACY_REPLACE_PREFIX, false, 2, null) != true) goto L26;
        L35:
            return LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD;
        L17:
            if (StringsKt.startsWith$default(r6, LandscapeRestrictionOperation.LEGACY_ADD_PREFIX, false, 2, null) != true) goto L19;
            r4 = true;
            goto L20
        L34:
            return LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        }
    }

    private static final /* synthetic */ LandscapeRestrictionOperation[] $values() {
        return new LandscapeRestrictionOperation[]{DIALOG_SHOW, DIALOG_FRAGMENT_SHOW, DIALOG_FRAGMENT_SHOW_NOW, DIALOG_FRAGMENT_SHOW_TRANSACTION, FRAGMENT_TRANSACTION_ADD, FRAGMENT_TRANSACTION_REPLACE, UNKNOWN};
    }

    @JvmStatic
    public static final LandscapeRestrictionOperation fromLegacyName(String r1) {
        return Companion.fromLegacyName(r1);
    }

    public static EnumEntries<LandscapeRestrictionOperation> getEntries() {
        return $ENTRIES;
    }

    static {
        DIALOG_SHOW = new LandscapeRestrictionOperation("DIALOG_SHOW", 0, "Dialog.show");
        DIALOG_FRAGMENT_SHOW = new LandscapeRestrictionOperation("DIALOG_FRAGMENT_SHOW", 1, "DialogFragment.show");
        DIALOG_FRAGMENT_SHOW_NOW = new LandscapeRestrictionOperation("DIALOG_FRAGMENT_SHOW_NOW", 2, "DialogFragment.showNow");
        DIALOG_FRAGMENT_SHOW_TRANSACTION = new LandscapeRestrictionOperation("DIALOG_FRAGMENT_SHOW_TRANSACTION", 3, "DialogFragment.show(transaction)");
        FRAGMENT_TRANSACTION_ADD = new LandscapeRestrictionOperation("FRAGMENT_TRANSACTION_ADD", 4, "FragmentTransaction.add");
        FRAGMENT_TRANSACTION_REPLACE = new LandscapeRestrictionOperation("FRAGMENT_TRANSACTION_REPLACE", 5, "FragmentTransaction.replace");
        UNKNOWN = new LandscapeRestrictionOperation("UNKNOWN", 6, "unknown");
        LandscapeRestrictionOperation[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static LandscapeRestrictionOperation[] values() {
        return (LandscapeRestrictionOperation[]) $VALUES.clone();
    }

    public final boolean isDialogFragmentShowOperation() {
        if (this != DIALOG_FRAGMENT_SHOW) goto L5;
    L10:
        return true;
    L5:
        if (this == DIALOG_FRAGMENT_SHOW_NOW) goto L10;
        if (this == DIALOG_FRAGMENT_SHOW_TRANSACTION) goto L10;
        return false;
    }

    public final String getTraceName$impl_mainlandRelease() {
        return this.traceName;
    }

    public static LandscapeRestrictionOperation valueOf(String r1) {
        return (LandscapeRestrictionOperation) a.a(LandscapeRestrictionOperation.class, r1);
    }

    private LandscapeRestrictionOperation(String r1, int r2, String r3) {
        super(r1, r2);
        this.traceName = r3;
    }
}
