package com.larus.community.impl.detail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.community.api.ICommunityService;
import com.larus.community.impl.applet.CreationAppletUiHelper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.service.ICreationAppletProfileProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailHostPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "argument", "Landroid/os/Bundle;", "enableProfilePage", "", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailHostPagerAdapter extends FragmentStateAdapter {
    public final Bundle a;
    public final boolean b;

    public final int getItemCount() {
        if (this.b == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public final Fragment createFragment(int r6) {
        if (r6 == 0) goto L34;
        if (r6 != 1) goto L32;
        String r7 = this.a.getString("creation");
        String r2 = null;
        if (r7 != null) goto L8;
    L20:
        UserCreation r8 = null;
    L21:
        if (r8 == null) goto L25;
        AuthorInfo r9 = r8.g;
        if (r9 == null) goto L25;
        r2 = r9.b;
    L25:
        Bundle r10 = new Bundle();
        r10.putString("key_user_id", r2);
        r10.putString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "slide_left");
        r10.putString("landing_tab", "creation");
        int r1 = CreationAppletUiHelper.a;
        Bundle r3 = this.a;
        Intrinsics.checkNotNullParameter(r10, "target");
        if (CreationAppletUiHelper.h(r3) == false) goto L28;
        r10.putBoolean("from_ai_creation_applet", true);
        r10.putBoolean("ai_creation_applet_is_root_page", false);
    L28:
        Fragment r11 = ICreationAppletProfileProvider.a.a(r10);
        if (r11 == null) goto L38;
        return r11;
    L38:
        return new Fragment();
    L8:
        if ((!StringsKt.isBlank(r7)) == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L20;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl((UserCreation) xt7.d.b.c(UserCreation.Companion.serializer(), r7));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r12) == false) goto L19;
        r12 = null;
    L19:
        r8 = (UserCreation) r12;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L32:
        throw new IllegalArgumentException("Invalid position: " + r6);
    L34:
        return ICommunityService.a.l1(this.a);
    }

    public CreationDetailHostPagerAdapter(Fragment r2, Bundle r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "argument");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}
