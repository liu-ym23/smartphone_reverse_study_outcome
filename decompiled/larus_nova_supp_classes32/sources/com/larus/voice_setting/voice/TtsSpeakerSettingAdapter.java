package com.larus.voice_setting.voice;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.voice_setting.voice.base.multitab.MultiTabVoiceListFragment;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/voice_setting/voice/TtsSpeakerSettingAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "children", "Ljava/util/HashMap;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/collections/HashMap;", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/HashMap;)V", "getItemCount", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsSpeakerSettingAdapter extends FragmentStateAdapter {
    public final HashMap<Integer, Fragment> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public final Fragment createFragment(int r2) {
        Fragment r3 = this.a.get(Integer.valueOf(r2));
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new MultiTabVoiceListFragment();
    }

    public TtsSpeakerSettingAdapter(Fragment r2, HashMap<Integer, Fragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "children");
        super(r2);
        this.a = r3;
    }
}
