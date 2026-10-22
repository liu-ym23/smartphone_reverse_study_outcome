package com.obric.assistant.guide.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.obric.assistant.guide.ui.AiKeyFragment;
import com.obric.assistant.guide.ui.LocalDataSearchFragment;
import com.obric.assistant.guide.ui.UserExperienceImprovmentFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/guide/adapter/UserGuideAdapterForAiPage;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isLocalDataSearchEnabled", "", "isImproveVoiceWakeupEnabled", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZZ)V", "()Z", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGuideAdapterForAiPage extends FragmentStateAdapter {
    public final boolean a;
    public final boolean b;

    public final int getItemCount() {
        return ((!this.a ? 1 : 0) + 1) + (!this.b ? 1 : 0);
    }

    public final Fragment createFragment(int r4) {
        if (r4 == 0) goto L27;
        boolean r1 = true;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L13;
        if (this.b == true) goto L11;
        return new UserExperienceImprovmentFragment();
    L11:
        throw new IllegalArgumentException("Invalid position");
    L13:
        throw new IllegalArgumentException("Invalid position");
    L15:
        if (this.a == true) goto L22;
        int r0 = LocalDataSearchFragment.f;
        if (r4 == (getItemCount() - 1)) goto L29;
        r1 = false;
    L29:
        return LocalDataSearchFragment.a.a(r1);
    L22:
        if (this.b == true) goto L25;
        return new UserExperienceImprovmentFragment();
    L25:
        throw new IllegalArgumentException("Invalid position");
    L27:
        return new AiKeyFragment();
    }

    public UserGuideAdapterForAiPage(FragmentActivity r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}
