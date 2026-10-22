package com.obric.cae.userAware.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.obric.cae.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public class DataCollectionEntryFragment extends Fragment {
    public DataCollectionEntryFragment() {
    }

    public static /* synthetic */ void a(DataCollectionEntryFragment r8, View r10) {
        r8.lambda$onCreateView$1(r10);
    }

    public static /* synthetic */ void b(DataCollectionEntryFragment r8, View r10) {
        r8.lambda$onCreateView$0(r10);
    }

    private /* synthetic */ void lambda$onCreateView$0(View r8) {
        startActivity(new Intent(getContext(), UserAwareLauncherActivity.class));     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        Log.e("DataEntryFragment", "UserAwareLauncherActivity not found");
    }

    private /* synthetic */ void lambda$onCreateView$1(View r8) {
        startActivity(new Intent(getContext(), CompanySceneCollectActivity.class));     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        Log.e("DataEntryFragment", "CompanySceneCollectActivity not found");
    }

    @Override // androidx.lifecycle.f
    public t0.a getDefaultViewModelCreationExtras() {
        return t0.a.C0158a.f12207b;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        int r12 = 0;
        View r13 = r8.inflate(R.layout.fragment_data_entry, r10, false);
        OListItemSettings r14 = (OListItemSettings) r13.findViewById(R.id.list_har_collect);
        OListItemSettings r15 = (OListItemSettings) r13.findViewById(R.id.list_company_scene_collect);
        if (r14 == null) goto L5;
        r14.setOnClickListener(new k(this, 1));
    L5:
        if (r15 == null) goto L7;
        r15.setOnClickListener(new n(this, r12));
    L7:
        return r13;
    }
}
