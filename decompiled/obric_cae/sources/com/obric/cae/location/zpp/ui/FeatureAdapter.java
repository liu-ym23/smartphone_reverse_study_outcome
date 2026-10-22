package com.obric.cae.location.zpp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.obric.cae.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FeatureAdapter extends ArrayAdapter<FeatureItem> {
    public FeatureAdapter(Context r8, List<FeatureItem> r10) {
        super(r8, 0, r10);
    }

    private boolean isNormalizedFeature(String r8) {
        if (r8.startsWith("har_state_") == false) goto L5;
    L18:
        return true;
    L5:
        if (r8.equals("wifi_connected_any") == true) goto L18;
        if (r8.equals("wifi_jaccard_index") == true) goto L18;
        if (r8.equals("cell_id_changed") == true) goto L18;
        if (r8.startsWith("geofence_is_") == true) goto L18;
        if (r8.startsWith("user_aware_") == true) goto L18;
        if (r8.equals("gps_outdoor_hint") == true) goto L18;
        return false;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r8, View r10, ViewGroup r11) {
        if (r10 != null) goto L5;
        r10 = LayoutInflater.from(getContext()).inflate(R.layout.list_item_feature, r11, false);
    L5:
        FeatureItem r12 = getItem(r8);
        TextView r13 = (TextView) r10.findViewById(R.id.feature_name);
        TextView r14 = (TextView) r10.findViewById(R.id.feature_value);
        ProgressBar r15 = (ProgressBar) r10.findViewById(R.id.feature_progress_bar);
        if (r12 == null) goto L11;
        r13.setText(r12.getName());
        r14.setText(String.format("%.3f", new Object[]{Float.valueOf(r12.getValue())}));
        if (isNormalizedFeature(r12.getName()) == false) goto L10;
        r15.setVisibility(0);
        r15.setMax(100);
        r15.setProgress((int) (r12.getValue() * 100.0f));
        goto L11
    L10:
        r15.setVisibility(8);
    L11:
        return r10;
    }
}
