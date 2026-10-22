package com.larus.browsertakeover.entry;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.larus.browsertakeover.api.IBrowserTakeoverService;
import com.larus.browsertakeover.ui.BrowserTakeoverDialog;
import com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ga9.e;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import jv8.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/browsertakeover/entry/BrowserTakeoverServiceImpl;", "Lcom/larus/browsertakeover/api/IBrowserTakeoverService;", "<init>", "()V", "open", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "request", "Lcom/larus/browsertakeover/api/BrowserTakeoverRequest;", "delegate", "Lcom/larus/browsertakeover/api/TakeoverTaskDelegate;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserTakeoverServiceImpl implements IBrowserTakeoverService {

    public static final class a {
    }

    static {
    }

    public BrowserTakeoverServiceImpl() {
    }

    @Override // com.larus.browsertakeover.api.IBrowserTakeoverService
    public final boolean a(FragmentActivity r8, hv8.a r9, RequestActionBrowserOperationInterceptor.CompletionDelegate r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        FragmentManager r0 = r8.getSupportFragmentManager();
        if (r8.isDestroyed() == false) goto L5;
    L57:
        r9.a(BrowserTakeoverOpenResult.ACTIVITY_UNAVAILABLE);
        return false;
    L5:
        if (r8.isFinishing() == true) goto L57;
        if (r0.isStateSaved() == true) goto L57;
        int r1 = ka9.a.a;
        c r2 = new c(0);
        AtomicReference r3 = ga9.a.a;
        e.a.getClass();
        if (Intrinsics.areEqual(((c) e.a(ga9.a.c("mobile_browser_takeover_enabled", e.c(r2)), c.class, r2)).a(), TriggerSendLoading.NO_LOADING) == false) goto L13;
        r9.a(BrowserTakeoverOpenResult.EXPERIMENT_DISABLED);
        return false;
    L13:
        hv8.c r4 = r9.g;
        if ((r4 instanceof hv8.c.a) == false) goto L17;
        int r5 = 2131034122;
    L20:
        if (r8.getResources().getBoolean(r5) == true) goto L24;
        r9.a(BrowserTakeoverOpenResult.TARGET_DISABLED);
        return false;
    L24:
        if (r0.findFragmentByTag("BrowserTakeoverDialog") == null) goto L28;
        r9.a(BrowserTakeoverOpenResult.REUSED);
        return true;
    L28:
        if (StringsKt.isBlank(r9.e) == false) goto L30;
    L53:
        r9.a(BrowserTakeoverOpenResult.INVALID_REQUEST);
        return false;
    L30:
        if (StringsKt.isBlank(r9.b) == true) goto L53;
        if (StringsKt.isBlank(r9.a) == true) goto L53;
        String r6 = com.larus.browsertakeover.entry.a.a;
        com.larus.browsertakeover.entry.a.C0068a r7 = new com.larus.browsertakeover.entry.a.C0068a(r9, r10);
        Intrinsics.checkNotNullParameter(r7, "entry");
        if (com.larus.browsertakeover.entry.a.a == null) goto L37;
        String r11 = null;
    L38:
        if (r11 != null) goto L62;
        r9.a(BrowserTakeoverOpenResult.SESSION_BUSY);
        return false;
    L62:
        BrowserTakeoverDialog r12 = new BrowserTakeoverDialog();     // Catch: IllegalStateException -> L48
        Bundle r13 = new Bundle();     // Catch: IllegalStateException -> L48
        r13.putString("browser_takeover_entry_id", r11);     // Catch: IllegalStateException -> L48
        r12.setArguments(r13);     // Catch: IllegalStateException -> L48
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L48
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "BrowserTakeoverDialog", r14);     // Catch: IllegalStateException -> L48
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r12, r14) == false) goto L60;
    L46:
        r9.a(BrowserTakeoverOpenResult.OPENED);     // Catch: IllegalStateException -> L48
        return true;
    L60:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L45:
        r12.show(r0, "BrowserTakeoverDialog");     // Catch: IllegalStateException -> L48
    L48:
        String r15 = com.larus.browsertakeover.entry.a.a;
        Intrinsics.checkNotNullParameter(r11, "id");
        if (Intrinsics.areEqual(com.larus.browsertakeover.entry.a.a, r11) == false) goto L51;
        com.larus.browsertakeover.entry.a.a = null;
        com.larus.browsertakeover.entry.a.b = null;
    L51:
        r9.a(BrowserTakeoverOpenResult.PAGE_OPEN_FAILED);
        return false;
    L37:
        r11 = UUID.randomUUID().toString();
        com.larus.browsertakeover.entry.a.a = r11;
        com.larus.browsertakeover.entry.a.b = r7;
        goto L38
    L17:
        if ((r4 instanceof hv8.c.b) == false) goto L56;
        r5 = 2131034123;
        goto L20
    L56:
        throw new NoWhenBranchMatchedException();
    }
}
