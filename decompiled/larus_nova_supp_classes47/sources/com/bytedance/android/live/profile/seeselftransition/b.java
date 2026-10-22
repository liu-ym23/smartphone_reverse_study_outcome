package com.bytedance.android.live.profile.seeselftransition;

import android.graphics.PointF;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    void BJ(a r1, ProfileMode r2);

    Pair<Integer, Integer> Ls();

    void Wl(k r1);

    void d80();

    void es(float r1);

    LifecycleOwner getLifecycleOwner();

    void ks(PointF r1);

    void setDressIconScale(float r1);

    void show(FragmentManager r1, String r2);

    PointF v10();
}
