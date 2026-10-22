package com.obric.assistant.interaction.impl.window.landscape.restriction;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J,\u0010 \u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010#\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0012\u0010$\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010%\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010&\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010'\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010(\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0012\u0010)\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010*\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u00102\u0006\u0010,\u001a\u00020\tH\u0007J\u0012\u0010-\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010.\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010/\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010/\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0012\u00100\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u00101\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u00102\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u00103\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u00104\u001a\u00020\u001fH\u0007J\r\u00105\u001a\u00020\u0013H\u0000¢\u0006\u0002\b6J\b\u00107\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionManager;", "", "<init>", "()V", "rules", "", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionRule;", "rulesById", "", "", "allowedDialogFragments", "Ljava/util/WeakHashMap;", "Landroidx/fragment/app/DialogFragment;", "allowedFragments", "Landroidx/fragment/app/Fragment;", "allowedDialogs", "Landroid/app/Dialog;", "visibleAllowedDialogs", "scopeAllowedDialogFragments", "", "scopeAllowedDialogs", "taskbarScopeAllowedDialogFragments", "taskbarScopeAllowedDialogs", "dialogFragmentDialogs", "dialogFragmentsByDialog", "markDialogFragmentIfAllowed", "fragment", "tag", "operation", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "isDialogFragmentAllowed", "", "markFragmentIfAllowed", "containerViewId", "", "isFragmentAllowed", "clearAllowedFragment", "markDialogFragmentAllowedByVisibleScope", "isDialogFragmentAllowedByVisibleScope", "markDialogFragmentAllowedByTaskbarScope", "isDialogFragmentAllowedByTaskbarScope", "bindDialogForAllowedDialogFragment", "markDialogAllowed", "dialog", "ruleId", "clearAllowedDialogFragment", "clearAllowedDialog", "isDialogAllowed", "isDialogAllowedByVisibleScope", "isDialogAllowedByTaskbarScope", "onDialogShown", "onDialogDismissed", "hasVisibleAllowedDialog", "clearForTest", "clearForTest$impl_mainlandRelease", "pruneVisibleAllowedDialogsLocked", "isDialogShowing", "isScopeDialogFragmentOperationAllowed", "isTaskbarScopeDialogFragmentOperationAllowed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeRestrictionManager {
    public static final LandscapeRestrictionManager INSTANCE = null;
    private static final WeakHashMap<DialogFragment, String> allowedDialogFragments = null;
    private static final WeakHashMap<Dialog, String> allowedDialogs = null;
    private static final WeakHashMap<Fragment, String> allowedFragments = null;
    private static final WeakHashMap<DialogFragment, Dialog> dialogFragmentDialogs = null;
    private static final WeakHashMap<Dialog, DialogFragment> dialogFragmentsByDialog = null;
    private static final List<LandscapeRestrictionRule> rules = null;
    private static final Map<String, LandscapeRestrictionRule> rulesById = null;
    private static final WeakHashMap<DialogFragment, Unit> scopeAllowedDialogFragments = null;
    private static final WeakHashMap<Dialog, Unit> scopeAllowedDialogs = null;
    private static final WeakHashMap<DialogFragment, Unit> taskbarScopeAllowedDialogFragments = null;
    private static final WeakHashMap<Dialog, Unit> taskbarScopeAllowedDialogs = null;
    private static final WeakHashMap<Dialog, String> visibleAllowedDialogs = null;

    private LandscapeRestrictionManager() {
    }

    public final void clearForTest$impl_mainlandRelease() {
        monitor-enter(this);
        allowedDialogFragments.clear();     // Catch: Throwable -> L6
        allowedFragments.clear();     // Catch: Throwable -> L6
        allowedDialogs.clear();     // Catch: Throwable -> L6
        visibleAllowedDialogs.clear();     // Catch: Throwable -> L6
        scopeAllowedDialogFragments.clear();     // Catch: Throwable -> L6
        scopeAllowedDialogs.clear();     // Catch: Throwable -> L6
        taskbarScopeAllowedDialogFragments.clear();     // Catch: Throwable -> L6
        taskbarScopeAllowedDialogs.clear();     // Catch: Throwable -> L6
        dialogFragmentDialogs.clear();     // Catch: Throwable -> L6
        dialogFragmentsByDialog.clear();     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new LandscapeRestrictionManager();
        List<LandscapeRestrictionRule> r0 = CollectionsKt.listOf(new LandscapeRestrictionRule[]{MultiTaskManagementLandscapeRule.INSTANCE, LocalDataSearchLandscapeRule.INSTANCE, PermissionRequestLandscapeRule.INSTANCE, AllowedFragmentTagLandscapeRule.INSTANCE});
        rules = r0;
        List<LandscapeRestrictionRule> r1 = r0;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r4 = r3.next();
        r2.put(((LandscapeRestrictionRule) r4).getRuleId(), r4);
        goto L4
    L6:
        rulesById = r2;
        allowedDialogFragments = new WeakHashMap();
        allowedFragments = new WeakHashMap();
        allowedDialogs = new WeakHashMap();
        visibleAllowedDialogs = new WeakHashMap();
        scopeAllowedDialogFragments = new WeakHashMap();
        scopeAllowedDialogs = new WeakHashMap();
        taskbarScopeAllowedDialogFragments = new WeakHashMap();
        taskbarScopeAllowedDialogs = new WeakHashMap();
        dialogFragmentDialogs = new WeakHashMap();
        dialogFragmentsByDialog = new WeakHashMap();
    }

    @JvmStatic
    public static final synchronized boolean hasVisibleAllowedDialog() {
        monitor-enter(LandscapeRestrictionManager.class);
        INSTANCE.pruneVisibleAllowedDialogsLocked();     // Catch: Throwable -> L8
        boolean r1 = !visibleAllowedDialogs.isEmpty();
        monitor-exit(LandscapeRestrictionManager.class);
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    private final void pruneVisibleAllowedDialogsLocked() {
        Iterator<Map.Entry<Dialog, String>> r0 = visibleAllowedDialogs.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<Dialog, String> r1 = r0.next();
        Dialog r2 = r1.getKey();
        String r3 = r1.getValue();
        LandscapeRestrictionRule r4 = rulesById.get(r3);
        boolean r5 = false;
        if (Intrinsics.areEqual(allowedDialogs.get(r2), r3) == true) goto L8;
    L15:
        if (r5 == false) goto L18;
        Intrinsics.checkNotNull(r2);
        if (isDialogShowing(r2) == true) goto L4;
    L18:
        r0.remove();
        goto L4
    L8:
        if (r4 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L15;
        r5 = true;
        goto L15
    L10:
        if (r4.isDialogOperationAllowed(LandscapeRestrictionOperation.DIALOG_SHOW) != true) goto L12;
        r6 = true;
        goto L13
    }

    @JvmStatic
    public static final synchronized void bindDialogForAllowedDialogFragment(DialogFragment r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r4 != null) goto L35;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L35:
        Dialog r1 = r4.getDialog();     // Catch: Throwable -> L32
        if (r1 != null) goto L11;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L11:
        dialogFragmentDialogs.put(r4, r1);     // Catch: Throwable -> L32
        dialogFragmentsByDialog.put(r1, r4);     // Catch: Throwable -> L32
        String r2 = allowedDialogFragments.get(r4);     // Catch: Throwable -> L32
        if (r2 == null) goto L14;
        LandscapeRestrictionRule r5 = rulesById.get(r2);     // Catch: Throwable -> L32
        if (r5 != null) goto L26;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L26:
        if (r5.isDialogOperationAllowed(LandscapeRestrictionOperation.DIALOG_SHOW) == true) goto L29;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L29:
        allowedDialogs.put(r1, r2);     // Catch: Throwable -> L32
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L14:
        if (scopeAllowedDialogFragments.containsKey(r4) == false) goto L17;
        scopeAllowedDialogs.put(r1, Unit.INSTANCE);     // Catch: Throwable -> L32
    L17:
        if (taskbarScopeAllowedDialogFragments.containsKey(r4) == false) goto L19;
        taskbarScopeAllowedDialogs.put(r1, Unit.INSTANCE);     // Catch: Throwable -> L32
    L19:
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void clearAllowedDialog(Dialog r2) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r2 != null) goto L15;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L15:
        allowedDialogs.remove(r2);     // Catch: Throwable -> L12
        visibleAllowedDialogs.remove(r2);     // Catch: Throwable -> L12
        scopeAllowedDialogs.remove(r2);     // Catch: Throwable -> L12
        taskbarScopeAllowedDialogs.remove(r2);     // Catch: Throwable -> L12
        DialogFragment r3 = dialogFragmentsByDialog.remove(r2);     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        allowedDialogFragments.remove(r3);     // Catch: Throwable -> L12
        allowedFragments.remove(r3);     // Catch: Throwable -> L12
        scopeAllowedDialogFragments.remove(r3);     // Catch: Throwable -> L12
        taskbarScopeAllowedDialogFragments.remove(r3);     // Catch: Throwable -> L12
        dialogFragmentDialogs.remove(r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void clearAllowedDialogFragment(DialogFragment r3) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r3 != null) goto L18;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L18:
        Dialog r1 = r3.getDialog();     // Catch: Throwable -> L15
        if (r1 != null) goto L10;
        r1 = dialogFragmentDialogs.get(r3);     // Catch: Throwable -> L15
    L10:
        allowedDialogFragments.remove(r3);     // Catch: Throwable -> L15
        allowedFragments.remove(r3);     // Catch: Throwable -> L15
        scopeAllowedDialogFragments.remove(r3);     // Catch: Throwable -> L15
        taskbarScopeAllowedDialogFragments.remove(r3);     // Catch: Throwable -> L15
        dialogFragmentDialogs.remove(r3);     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        dialogFragmentsByDialog.remove(r1);     // Catch: Throwable -> L15
        allowedDialogs.remove(r1);     // Catch: Throwable -> L15
        visibleAllowedDialogs.remove(r1);     // Catch: Throwable -> L15
        scopeAllowedDialogs.remove(r1);     // Catch: Throwable -> L15
        taskbarScopeAllowedDialogs.remove(r1);     // Catch: Throwable -> L15
    L13:
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void clearAllowedFragment(Fragment r2) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r2 != null) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L13:
        allowedFragments.remove(r2);     // Catch: Throwable -> L10
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogAllowed(Dialog r2) {
        monitor-enter(LandscapeRestrictionManager.class);
        boolean r3 = isDialogAllowed(r2, LandscapeRestrictionOperation.DIALOG_SHOW);     // Catch: Throwable -> L7
        monitor-exit(LandscapeRestrictionManager.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogAllowedByTaskbarScope(Dialog r2) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r2 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        boolean r3 = taskbarScopeAllowedDialogs.containsKey(r2);     // Catch: Throwable -> L11
        monitor-exit(LandscapeRestrictionManager.class);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogAllowedByVisibleScope(Dialog r2) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r2 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        boolean r3 = scopeAllowedDialogs.containsKey(r2);     // Catch: Throwable -> L11
        monitor-exit(LandscapeRestrictionManager.class);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    private final boolean isDialogShowing(Dialog r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Boolean.valueOf(r3.isShowing()));     // Catch: Throwable -> L4
    L6:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = r1;
    L10:
        return ((Boolean) r4).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final boolean isScopeDialogFragmentOperationAllowed(LandscapeRestrictionOperation r2) {
        if (r2.isDialogFragmentShowOperation() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD) goto L8;
        return false;
    }

    private final boolean isTaskbarScopeDialogFragmentOperationAllowed(LandscapeRestrictionOperation r2) {
        if (r2.isDialogFragmentShowOperation() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD) goto L8;
        return false;
    }

    @JvmStatic
    public static final synchronized void onDialogDismissed(Dialog r1) {
        monitor-enter(LandscapeRestrictionManager.class);
        clearAllowedDialog(r1);     // Catch: Throwable -> L7
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void onDialogShown(Dialog r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        if (r4 != null) goto L31;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L31:
        String r1 = allowedDialogs.get(r4);     // Catch: Throwable -> L28
        if (r1 != null) goto L12;
        visibleAllowedDialogs.remove(r4);     // Catch: Throwable -> L28
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L12:
        LandscapeRestrictionRule r2 = rulesById.get(r1);     // Catch: Throwable -> L28
        if (r2 != null) goto L15;
    L25:
        visibleAllowedDialogs.remove(r4);     // Catch: Throwable -> L28
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L15:
        if (r2.isDialogOperationAllowed(LandscapeRestrictionOperation.DIALOG_SHOW) == false) goto L25;
        if (INSTANCE.isDialogShowing(r4) == true) goto L22;
        visibleAllowedDialogs.remove(r4);     // Catch: Throwable -> L28
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L22:
        visibleAllowedDialogs.put(r4, r1);     // Catch: Throwable -> L28
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogAllowed(Dialog r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L20
        if (r3 != null) goto L9;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L9:
        String r5 = allowedDialogs.get(r3);     // Catch: Throwable -> L20
        if (r5 != null) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L13:
        LandscapeRestrictionRule r6 = rulesById.get(r5);     // Catch: Throwable -> L20
        if (r6 != null) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        boolean r7 = r6.isDialogOperationAllowed(r4);     // Catch: Throwable -> L20
        monitor-exit(LandscapeRestrictionManager.class);
        return r7;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogFragmentAllowed(Fragment r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L24
        if ((r3 instanceof DialogFragment) == false) goto L8;
        DialogFragment r5 = (DialogFragment) r3;     // Catch: Throwable -> L24
    L10:
        if (r5 != null) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L13:
        String r6 = allowedDialogFragments.get(r5);     // Catch: Throwable -> L24
        if (r6 != null) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        LandscapeRestrictionRule r7 = rulesById.get(r6);     // Catch: Throwable -> L24
        if (r7 != null) goto L21;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L21:
        boolean r8 = r7.isDialogFragmentOperationAllowed(r4);     // Catch: Throwable -> L24
        monitor-exit(LandscapeRestrictionManager.class);
        return r8;
    L8:
        r5 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogFragmentAllowedByTaskbarScope(Fragment r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L20
        if ((r3 instanceof DialogFragment) == false) goto L8;
        DialogFragment r5 = (DialogFragment) r3;     // Catch: Throwable -> L20
    L10:
        if (r5 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        if (INSTANCE.isTaskbarScopeDialogFragmentOperationAllowed(r4) == true) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        boolean r6 = taskbarScopeAllowedDialogFragments.containsKey(r5);     // Catch: Throwable -> L20
        monitor-exit(LandscapeRestrictionManager.class);
        return r6;
    L8:
        r5 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isDialogFragmentAllowedByVisibleScope(Fragment r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L20
        if ((r3 instanceof DialogFragment) == false) goto L8;
        DialogFragment r5 = (DialogFragment) r3;     // Catch: Throwable -> L20
    L10:
        if (r5 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        if (INSTANCE.isScopeDialogFragmentOperationAllowed(r4) == true) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        boolean r6 = scopeAllowedDialogFragments.containsKey(r5);     // Catch: Throwable -> L20
        monitor-exit(LandscapeRestrictionManager.class);
        return r6;
    L8:
        r5 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean isFragmentAllowed(Fragment r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L24
        if (r3 != null) goto L10;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L10:
        if ((r3 instanceof DialogFragment) == false) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L13:
        String r5 = allowedFragments.get(r3);     // Catch: Throwable -> L24
        if (r5 != null) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        LandscapeRestrictionRule r6 = rulesById.get(r5);     // Catch: Throwable -> L24
        if (r6 != null) goto L21;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L21:
        boolean r7 = r6.isFragmentOperationAllowed(r4);     // Catch: Throwable -> L24
        monitor-exit(LandscapeRestrictionManager.class);
        return r7;
    L24:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void markDialogAllowed(Dialog r3, String r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "ruleId");     // Catch: Throwable -> L19
        if (r3 != null) goto L8;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L8:
        LandscapeRestrictionRule r1 = rulesById.get(r4);     // Catch: Throwable -> L19
        if (r1 != null) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L13:
        if (r1.isDialogOperationAllowed(LandscapeRestrictionOperation.DIALOG_SHOW) == true) goto L16;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L16:
        allowedDialogs.put(r3, r4);     // Catch: Throwable -> L19
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean markDialogFragmentAllowedByTaskbarScope(Fragment r2, LandscapeRestrictionOperation r3) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r3, "operation");     // Catch: Throwable -> L21
        if ((r2 instanceof DialogFragment) == false) goto L8;
        DialogFragment r4 = (DialogFragment) r2;     // Catch: Throwable -> L21
    L10:
        if (r4 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        if (r3.isDialogFragmentShowOperation() == true) goto L17;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L17:
        taskbarScopeAllowedDialogFragments.put(r4, Unit.INSTANCE);     // Catch: Throwable -> L21
        monitor-exit(LandscapeRestrictionManager.class);
        return true;
    L8:
        r4 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean markDialogFragmentAllowedByVisibleScope(Fragment r3, LandscapeRestrictionOperation r4) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r4, "operation");     // Catch: Throwable -> L25
        if ((r3 instanceof DialogFragment) == false) goto L8;
        DialogFragment r5 = (DialogFragment) r3;     // Catch: Throwable -> L25
    L10:
        if (r5 != null) goto L14;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L14:
        if (INSTANCE.isScopeDialogFragmentOperationAllowed(r4) == true) goto L18;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L18:
        if (hasVisibleAllowedDialog() == true) goto L21;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L21:
        scopeAllowedDialogFragments.put(r5, Unit.INSTANCE);     // Catch: Throwable -> L25
        monitor-exit(LandscapeRestrictionManager.class);
        return true;
    L8:
        r5 = null;
    L25:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void markDialogFragmentIfAllowed(Fragment r6, String r7, LandscapeRestrictionOperation r8) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r8, "operation");     // Catch: Throwable -> L25
        Object r2 = null;
        if ((r6 instanceof DialogFragment) == false) goto L8;
        DialogFragment r1 = (DialogFragment) r6;     // Catch: Throwable -> L25
    L9:
        if (r1 != null) goto L12;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L12:
        Iterator<T> r3 = rules.iterator();     // Catch: Throwable -> L25
    L14:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();     // Catch: Throwable -> L25
        if (((LandscapeRestrictionRule) r4).matchesDialogFragmentShow(r6, r7, r8) == false) goto L14;
        r2 = r4;
    L18:
        LandscapeRestrictionRule r5 = (LandscapeRestrictionRule) r2;     // Catch: Throwable -> L25
        if (r5 != null) goto L22;
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L22:
        allowedDialogFragments.put(r1, r5.getRuleId());     // Catch: Throwable -> L25
        monitor-exit(LandscapeRestrictionManager.class);
        return;
    L8:
        r1 = null;
    L25:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized boolean markFragmentIfAllowed(Fragment r5, String r6, int r7, LandscapeRestrictionOperation r8) {
        monitor-enter(LandscapeRestrictionManager.class);
        Intrinsics.checkNotNullParameter(r8, "operation");     // Catch: Throwable -> L28
        if (r5 != null) goto L10;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L10:
        if ((r5 instanceof DialogFragment) == false) goto L13;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L13:
        Iterator<T> r2 = rules.iterator();     // Catch: Throwable -> L28
    L15:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();     // Catch: Throwable -> L28
        if (((LandscapeRestrictionRule) r3).matchesFragmentTransaction(r5, r6, r7, r8) == false) goto L15;
    L20:
        LandscapeRestrictionRule r4 = (LandscapeRestrictionRule) r3;     // Catch: Throwable -> L28
        if (r4 != null) goto L24;
        monitor-exit(LandscapeRestrictionManager.class);
        return false;
    L24:
        allowedFragments.put(r5, r4.getRuleId());     // Catch: Throwable -> L28
        monitor-exit(LandscapeRestrictionManager.class);
        return true;
    L19:
        r3 = null;
    L28:
        th = move-exception;
        throw th;
    }
}
