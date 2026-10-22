package com.zte.miboard.recommend.nubiapush;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences r5, String r10) {
        RegisterAgainUtils.a(r5, r10);
    }
}
