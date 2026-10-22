package com.obric.cae.BWDL.BwdlDrop.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.oui.lisitem.OCardListItem;
import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import defpackage.b;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ScanResultAdapter extends BaseAdapter {
    private static final String TAG = "ScanResultAdapter";
    private List<BWDLDiscoveryData> mArrayList;
    private Context mContext;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public ScanResultAdapter(Context r8, LayoutInflater r10, AdapterView.OnItemClickListener r11) {
        this.mContext = r8;
        this.mInflater = r10;
        this.mArrayList = new CopyOnWriteArrayList();
        this.mOnItemClickListener = r11;
    }

    public static /* synthetic */ AdapterView.OnItemClickListener access$000(ScanResultAdapter r8) {
        return r8.mOnItemClickListener;
    }

    private int getPosition(int r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.mArrayList.size()) goto L9;
        if (this.mArrayList.get(r10).getBWDLDevice().getDeviceId() == r8) goto L10;
        r10 = r10 + 1;
    L10:
        b.m("position:", r10, TAG);
        return r10;
    L9:
        r10 = -1;
        goto L10
    }

    public void add(BWDLDiscoveryData r8) {
        int r10 = getPosition(r8.getBWDLDevice().getDeviceId());
        List<BWDLDiscoveryData> r11 = this.mArrayList;
        if (r10 < 0) goto L5;
        r11.set(r10, r8);
        return;
    L5:
        r11.add(r8);
    }

    public void clear() {
        this.mArrayList.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mArrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r8) {
        return this.mArrayList.get(r8);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r8) {
        return 0;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"MissingPermission"})
    public View getView(final int r8, final View r10, final ViewGroup r11) {
        String r12 = null;
        if (r10 != null) goto L5;
        r10 = this.mInflater.inflate(R.layout.scan_result, null);
    L5:
        OCardListItem r13 = (OCardListItem) r10.findViewById(R.id.device_name);
        BWDLDiscoveryData r14 = this.mArrayList.get(r8);
        if (r14 == null) goto L17;
        BWDLAdvertisingData r15 = r14.getAdvertisingData();
        if (r15 != null) goto L10;
    L12:
        r13.setTitle(r12);
        int r16 = OCardListItem.L;
        if (r8 != 0) goto L15;
        int r17 = 1;
    L16:
        r13.setCardPosition(r17);
        r13.setOnContentClickListener(new AnonymousClass1(this, r11, r10, r8));
        goto L17
    L15:
        r17 = 2;
        goto L16
    L10:
        if (r15.getFeatureData() == null) goto L12;
        r12 = new String(r15.getFeatureData(), StandardCharsets.UTF_8);
        CaeLog.d(TAG, "name:".concat(r12));
    L17:
        return r10;
    }
}
