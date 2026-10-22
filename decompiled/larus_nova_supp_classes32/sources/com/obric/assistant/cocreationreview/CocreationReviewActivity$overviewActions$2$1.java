package com.obric.assistant.cocreationreview;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$overviewActions$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public CocreationReviewActivity$overviewActions$2$1(Object r8) {
        super(0, r8, CocreationReviewActivity.class, "requestReviewShortcut", "requestReviewShortcut()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m415invoke() {
        AppCompatActivity r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        r0.getClass();
        int r2 = CocreationReviewShortcut.a;
        String r3 = MainView.REVIEW.getTitle();
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r3, "label");
        Integer r9 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L51;
        CocreationReviewShortcut.Result r4 = CocreationReviewShortcut.Result.UNSUPPORTED;
    L35:
        int r5 = CocreationReviewActivity.g.b[r4.ordinal()];
        if (r5 != 1) goto L38;
    L48:
        if (r9 == null) goto L55;
        Toast.makeText(r0, r9.intValue(), 0).show();
        return;
    L55:
        return;
    L38:
        if (r5 != 2) goto L40;
        r9 = 2131899746;
        goto L48
    L40:
        if (r5 != 3) goto L42;
        r9 = 2131897500;
        goto L48
    L42:
        if (r5 != 4) goto L45;
        r9 = 2131899191;
        goto L48
    L45:
        throw new NoWhenBranchMatchedException();
    L51:
        ShortcutManager r6 = (ShortcutManager) r0.getSystemService(ShortcutManager.class);     // Catch: RuntimeException -> L32
        if (r6 != null) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == true) goto L13;
        r4 = CocreationReviewShortcut.Result.UNSUPPORTED;     // Catch: RuntimeException -> L32
        goto L35
    L13:
        ShortcutInfo.Builder r7 = new ShortcutInfo.Builder(r0, "cocreation_review").setShortLabel(r3).setLongLabel(r3).setIcon(Icon.createWithResource(r0, 2131233995));     // Catch: RuntimeException -> L32
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: RuntimeException -> L32
        Intent r10 = new Intent(r0, CocreationReviewActivity.class);     // Catch: RuntimeException -> L32
        r10.setAction("android.intent.action.VIEW");     // Catch: RuntimeException -> L32
        r10.setFlags(335544320);     // Catch: RuntimeException -> L32
        ShortcutInfo r11 = r7.setIntent(r10).build();     // Catch: RuntimeException -> L32
        List<ShortcutInfo> r12 = r6.getPinnedShortcuts();     // Catch: RuntimeException -> L32
        if ((r12 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r13 = r12.iterator();     // Catch: RuntimeException -> L32
    L20:
        if (r13.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((ShortcutInfo) r13.next()).getId(), "cocreation_review") == false) goto L20;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L28;
        r6.updateShortcuts(CollectionsKt.listOf(r11));     // Catch: RuntimeException -> L32
        r4 = CocreationReviewShortcut.Result.ALREADY_PINNED;     // Catch: RuntimeException -> L32
    L34:
        int r15 = s3.a;
        s3.b("shortcut", "request result=" + r4);
        goto L35
    L28:
        if (r6.requestPinShortcut(r11, null) == false) goto L30;
        r4 = CocreationReviewShortcut.Result.REQUESTED;     // Catch: RuntimeException -> L32
        goto L34
    L30:
        r4 = CocreationReviewShortcut.Result.FAILED;     // Catch: RuntimeException -> L32
    L24:
        r14 = false;
        goto L25
    L16:
        if (r12.isEmpty() == false) goto L18;
    L8:
        if (r6.isRequestPinShortcutSupported() != true) goto L10;
        r8 = true;
    L32:
        e = move-exception;
        int r16 = s3.a;
        s3.c("shortcut", "request failed: ".concat(e.getClass().getSimpleName()));
        r4 = CocreationReviewShortcut.Result.FAILED;
        goto L34
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m415invoke();
        return Unit.INSTANCE;
    }
}
