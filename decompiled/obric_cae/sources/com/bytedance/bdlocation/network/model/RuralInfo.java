package com.bytedance.bdlocation.network.model;

import android.aimedia.a;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class RuralInfo {

    @b("ASCIName")
    public String asciName;

    @b("Code")
    public String code;

    @b("GeoNameID")
    public long geoNameID;

    @b("LocalID")
    public String localID;

    @b("Name")
    public String name;

    public RuralInfo() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("Town{code=");
        r8.append(this.code);
        r8.append("', geoNameID='");
        r8.append(this.geoNameID);
        r8.append("', asciName='");
        r8.append(this.asciName);
        r8.append("', name='");
        r8.append(this.name);
        r8.append("', localID='");
        return a.i(r8, this.localID, "'}");
    }
}
