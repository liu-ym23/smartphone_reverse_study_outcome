package com.larus.bmhome.block.presentation;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kc8.c;
import kc8.d;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements d {
    public final Fragment a;
    public final Function0<y> b;

    /* JADX INFO: renamed from: com.larus.bmhome.block.presentation.a$a, reason: collision with other inner class name */
    public static final class C0034a {
    }

    static {
    }

    @Override // kc8.d
    public final void a(BlockDetailRequest r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Fragment r1 = this.a;
    L3:
        FragmentActivity r2 = null;
        if (r1 == null) goto L9;
        if ((r1 instanceof c) == true) goto L7;
        r1 = r1.getParentFragment();
        goto L3
    L7:
        c r3 = (c) r1;
    L10:
        if (r3 == null) goto L14;
        boolean r4 = true;
        if (r3.FV(r6) != true) goto L14;
    L15:
        if (r4 == false) goto L17;
        return;
    L17:
        Fragment r5 = this.a;
        if (r5 == null) goto L20;
        FragmentActivity r7 = r5.getActivity();
    L22:
        if ((r7 instanceof FragmentActivity) == true) goto L25;
        r7 = null;
    L25:
        if (r7 != null) goto L32;
        Activity r8 = AppHost.a.a().getCurrentActivity();
        if ((r8 instanceof FragmentActivity) == false) goto L29;
        r2 = (FragmentActivity) r8;
    L29:
        if (r2 != null) goto L31;
        return;
    L31:
        r7 = r2;
    L32:
        FragmentManager r9 = r7.getSupportFragmentManager();
        if (r9.isStateSaved() == false) goto L35;
    L45:
        FLogger.a.w("BlockDetailNavigator", "skip open block detail because fragment state is saved");
        return;
    L35:
        if (r9.isDestroyed() == true) goto L45;
        String r10 = "BlockDetailDialogFragment_" + r6.getBlock();
        if (r9.findFragmentByTag(r10) != null) goto L53;
        int r11 = BlockDetailDialogFragment.i;
        y r12 = (y) this.b.invoke();
        Intrinsics.checkNotNullParameter(r6, "request");
        BlockDetailDialogFragment.b.a = r12;
        BlockDetailDialogFragment r0 = new BlockDetailDialogFragment();
        Bundle r13 = new Bundle();
        r13.putSerializable("arg_block_detail_request", r6);
        r0.setArguments(r13);
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r10, r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r0, r14) == true) goto L54;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L44:
        r0.show(r9, r10);
        return;
    L54:
        return;
    L53:
        return;
    L20:
        r7 = null;
    L14:
        r4 = false;
        goto L15
    L9:
        r3 = null;
        goto L10
    }

    public a(Fragment r2, Function0<y> r3) {
        Intrinsics.checkNotNullParameter(r3, "globalConfigProvider");
        this.a = r2;
        this.b = r3;
    }
}
