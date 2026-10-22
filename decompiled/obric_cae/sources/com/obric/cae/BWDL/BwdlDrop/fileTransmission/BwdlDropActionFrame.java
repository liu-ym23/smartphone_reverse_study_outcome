package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropActionFrame {
    public static final String HEADER = "action";
    private int mActionId;
    private String mActionName;
    private JSONObject mExtra;

    public BwdlDropActionFrame(int r8, String r10, JSONObject r11) {
        this.mActionId = r8;
        this.mActionName = r10;
        this.mExtra = r11;
    }

    private void parseAction(String r8) {
        String[] r10 = r8.split("[?]", 2);
        String r11 = r10[0];
        this.mExtra = new JSONObject(r10[1]);     // Catch: JSONException -> L5
    L7:
        String[] r12 = r11.split(BdimCategoryConstants.SEPARATOR_COLON);
        this.mActionId = Integer.parseInt(r12[1]);     // Catch: NumberFormatException -> L10
    L12:
        this.mActionName = r12[2];
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String getActionName() {
        return this.mActionName;
    }

    public JSONObject getExtra() {
        return this.mExtra;
    }

    public void setExtra(JSONObject r8) {
        this.mExtra = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("action:");
        r8.append(this.mActionId);
        r8.append(BdimCategoryConstants.SEPARATOR_COLON);
        r8.append(this.mActionName);
        if (this.mExtra == null) goto L6;
        r8.append("?");
        r8.append(this.mExtra);
    L6:
        return r8.toString();
    }

    public BwdlDropActionFrame(String r8) {
        parseAction(r8);
    }
}
