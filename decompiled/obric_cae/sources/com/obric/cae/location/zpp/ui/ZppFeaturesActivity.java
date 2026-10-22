package com.obric.cae.location.zpp.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.obric.cae.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ZppFeaturesActivity extends Activity {
    public static final String EXTRA_FEATURE_NAMES = "feature_names";
    public static final String EXTRA_FEATURE_VALUES = "feature_values";
    private static final String TAG = "ZppFeaturesActivity";

    public ZppFeaturesActivity() {
    }

    @Override // android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_zpp_features);
        ListView r10 = (ListView) findViewById(R.id.features_list_view);
        TextView r11 = (TextView) findViewById(R.id.features_title);
        ArrayList<String> r12 = getIntent().getStringArrayListExtra(EXTRA_FEATURE_NAMES);
        float[] r13 = getIntent().getFloatArrayExtra(EXTRA_FEATURE_VALUES);
        if (r12 == null) goto L12;
        if (r13 == null) goto L12;
        if (r12.size() != r13.length) goto L12;
        ArrayList r14 = new ArrayList();
        int r15 = 0;
    L9:
        if (r15 >= r12.size()) goto L11;
        r14.add(new FeatureItem(r12.get(r15), r13[r15]));
        r15 = r15 + 1;
        goto L9
    L11:
        r10.setAdapter(new FeatureAdapter(this, r14));
        return;
    L12:
        r11.setText("No feature data available.");
    }
}
