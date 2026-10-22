package com.obric.cae.statusReport.wifi;

import com.obric.cae.log.CaeLog;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public class UPnPDevice {
    private static final String LINE_END = "\r\n";
    private static final String TAG = "UPnPDevice";
    private String mDeviceType;
    private String mFriendlyName;
    private final String mHostAddress;
    private final String mLocation;
    private String mManufacturer;
    private String mManufacturerURL;
    private String mModelDescription;
    private String mModelName;
    private String mModelNumber;
    private String mModelURL;
    private String mPresentationURL;
    private String mSerialNumber;
    private String mXmlData;

    public UPnPDevice(String r8, String r10) {
        this.mHostAddress = r8;
        this.mLocation = r10;
    }

    private void updateValue(XmlPullParser r8) {
        String r10 = r8.getName();
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -2010829484: goto L42;
            case -1969347631: goto L38;
            case -1859924717: goto L34;
            case -619048570: goto L30;
            case 83787357: goto L26;
            case 346619858: goto L22;
            case 418072542: goto L18;
            case 461933014: goto L14;
            case 781190832: goto L10;
            case 1714273269: goto L6;
            default: goto L45;
        };
    L45:
        switch(r11) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            default: goto L67;
        };
    L47:
        this.mPresentationURL = r8.nextText();
        return;
    L48:
        this.mDeviceType = r8.nextText();
        return;
    L49:
        this.mFriendlyName = r8.nextText();
        return;
    L50:
        this.mManufacturerURL = r8.nextText();
        return;
    L51:
        this.mModelNumber = r8.nextText();
        return;
    L52:
        this.mSerialNumber = r8.nextText();
        return;
    L53:
        this.mModelURL = r8.nextText();
        return;
    L54:
        this.mModelDescription = r8.nextText();
        return;
    L55:
        this.mManufacturer = r8.nextText();
        return;
    L56:
        this.mModelName = r8.nextText();
        return;
    L67:
        return;
    L6:
        if (r10.equals("presentationURL") == false) goto L45;
        r11 = 9;
        goto L45
    L10:
        if (r10.equals("deviceType") == false) goto L45;
        r11 = 8;
        goto L45
    L14:
        if (r10.equals("friendlyName") == false) goto L45;
        r11 = 7;
        goto L45
    L18:
        if (r10.equals("manufacturerURL") == false) goto L45;
        r11 = 6;
        goto L45
    L22:
        if (r10.equals("modelNumber") == false) goto L45;
        r11 = 5;
        goto L45
    L26:
        if (r10.equals("serialNumber") == false) goto L45;
        r11 = 4;
        goto L45
    L30:
        if (r10.equals("modelURL") == false) goto L45;
        r11 = 3;
        goto L45
    L34:
        if (r10.equals("modelDescription") == false) goto L45;
        r11 = 2;
        goto L45
    L38:
        if (r10.equals("manufacturer") == false) goto L45;
        r11 = 1;
        goto L45
    L42:
        if (r10.equals("modelName") == false) goto L45;
        r11 = 0;
        goto L45
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public String getFriendlyName() {
        return this.mFriendlyName;
    }

    public String getHostAddress() {
        return this.mHostAddress;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getManufacturerURL() {
        return this.mManufacturerURL;
    }

    public String getModelDescription() {
        return this.mModelDescription;
    }

    public String getModelName() {
        return this.mModelName;
    }

    public String getModelNumber() {
        return this.mModelNumber;
    }

    public String getModelURL() {
        return this.mModelURL;
    }

    public String getPresentationURL() {
        return this.mPresentationURL;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    public String getXmlData() {
        return this.mXmlData;
    }

    public boolean parseXmlData(String r8) {
        this.mXmlData = r8;
        XmlPullParser r10 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Exception -> L14
        r10.setInput(new StringReader(r8));     // Catch: Exception -> L14
        int r11 = r10.getEventType();     // Catch: Exception -> L14
    L5:
        if (r11 == 1) goto L13;
        if (2 != r11) goto L11;
        if (r10.getDepth() != 3) goto L11;
        updateValue(r10);     // Catch: Exception -> L14
    L11:
        r11 = r10.next();     // Catch: Exception -> L14
        goto L5
    L13:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        CaeLog.i(TAG, "parse xml exception:" + e.getLocalizedMessage());
        return false;
    }

    public String toString() {
        return "HostAddress: " + this.mHostAddress + "\r\nLocation: " + this.mLocation + "\r\nFriendlyName: " + this.mFriendlyName + "\r\nModelName: " + this.mModelName + "\r\nModelDescription: " + this.mModelDescription + "\r\nDeviceType: " + this.mDeviceType + "\r\nPresentationURL: " + this.mPresentationURL + "\r\nSerialNumber: " + this.mSerialNumber + "\r\nModelURL: " + this.mModelURL + "\r\nModelNumber: " + this.mModelNumber + "\r\nManufacturer: " + this.mManufacturer + "\r\nManufacturerURL: " + this.mManufacturerURL;
    }
}
