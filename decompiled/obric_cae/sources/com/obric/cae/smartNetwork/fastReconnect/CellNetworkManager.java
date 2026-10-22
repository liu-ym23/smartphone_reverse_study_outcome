package com.obric.cae.smartNetwork.fastReconnect;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CellNetworkManager {
    private final String CELL_INFO_XML_FILE_NAME;
    private final String CELL_INFO_XML_PATH_NAME;
    private final String TAG;
    private final Map<Long, CellNetworkInfo> mCellNetworkInfoMap;
    private final Context mContext;

    public CellNetworkManager(Context r8) {
        this.TAG = "CellNetworkManager";
        this.CELL_INFO_XML_PATH_NAME = "/data/";
        this.CELL_INFO_XML_FILE_NAME = "/cell_info.xml";
        this.mCellNetworkInfoMap = new HashMap();
        this.mContext = r8;
    }

    private String getCellInfoFilePath() {
        File r8 = this.mContext.getExternalFilesDir("/data/");
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getAbsolutePath() + "/cell_info.xml";
    }

    private void mergeCellNetworkInfo(CellNetworkInfo r8, CellNetworkInfo r10) {
        if (r8 == null) goto L14;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r8.getCellId() == r10.getCellId()) goto L8;
        return;
    L8:
        Iterator<String> r11 = r10.getNetworkList().iterator();
    L10:
        if (r11.hasNext() == false) goto L21;
        String r12 = r11.next();
        if (r8.getNetworkList().contains(r12) == true) goto L10;
        r8.addNetwork(r12);
        goto L10
    L21:
        return;
    }

    public void addOrUpdateCellInfo(CellNetworkInfo r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (isCellIdMatchSuccess(r8.getCellId()) == false) goto L7;
        mergeCellNetworkInfo(this.mCellNetworkInfoMap.get(Long.valueOf(r8.getCellId())), r8);
        return;
    L7:
        this.mCellNetworkInfoMap.put(Long.valueOf(r8.getCellId()), r8);
    }

    public boolean isCellIdMatchSuccess(long r8) {
        return this.mCellNetworkInfoMap.containsKey(Long.valueOf(r8));
    }

    public void loadFromStore() {
        Iterator<CellNetworkInfo> r8 = CellNetworkStore.readCellInfoFromFile(getCellInfoFilePath()).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        CellNetworkInfo r10 = r8.next();
        this.mCellNetworkInfoMap.put(Long.valueOf(r10.getCellId()), r10);
        goto L4
    L6:
        Iterator<Long> r11 = this.mCellNetworkInfoMap.keySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        CaeLog.d("CellNetworkManager", " " + this.mCellNetworkInfoMap.get(Long.valueOf(r11.next().longValue())).getNetworkList());
        goto L8
    }

    public void saveToStore() {
        CellNetworkStore.writeCellInfoToFile(new ArrayList(this.mCellNetworkInfoMap.values()), getCellInfoFilePath());
    }
}
