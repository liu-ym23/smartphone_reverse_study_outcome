package com.ss.ugc.clientai.core.api;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001=B\u0011\u0012\b\b\u0002\u00105\u001a\u000204¢\u0006\u0004\b;\u0010:J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR2\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartInputData;", "", "", "", "inputMap", "importantMap", "toString", "runKey", "Ljava/lang/String;", "getRunKey", "()Ljava/lang/String;", "setRunKey", "(Ljava/lang/String;)V", "enterType", "getEnterType", "setEnterType", "", "forTrack", "Z", "getForTrack", "()Z", "setForTrack", "(Z)V", "inputFeaturesMap", "Ljava/util/Map;", "getInputFeaturesMap", "()Ljava/util/Map;", "setInputFeaturesMap", "(Ljava/util/Map;)V", "importantExtFeaturesMap", "getImportantExtFeaturesMap", "setImportantExtFeaturesMap", "", "inputFloatArray", "[F", "getInputFloatArray", "()[F", "setInputFloatArray", "([F)V", "", "inputByteArray", "[B", "getInputByteArray", "()[B", "setInputByteArray", "([B)V", "inputExtObj", "Ljava/lang/Object;", "getInputExtObj", "()Ljava/lang/Object;", "setInputExtObj", "(Ljava/lang/Object;)V", "", "capacity", "I", "getCapacity", "()I", "setCapacity", "(I)V", "<init>", "Companion", "a", "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartInputData {
    public static final a Companion = null;
    private int capacity;
    private String enterType;
    private boolean forTrack;
    private Map<String, Object> importantExtFeaturesMap;
    private byte[] inputByteArray;
    private Object inputExtObj;
    private Map<String, Object> inputFeaturesMap;
    private float[] inputFloatArray;
    private String runKey;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SmartInputData() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final Map<String, Object> importantMap() {
        Map<String, Object> r0 = this.importantExtFeaturesMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        HashMap r1 = new HashMap();
        this.importantExtFeaturesMap = r1;
        return r1;
    }

    public final Map<String, Object> inputMap() {
        Map<String, Object> r0 = this.inputFeaturesMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        HashMap r1 = new HashMap(this.capacity);
        this.inputFeaturesMap = r1;
        return r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{");
        if (this.runKey == null) goto L6;
        r0.append("runKey:" + this.runKey);
    L6:
        if (this.enterType == null) goto L8;
        r0.append(", enterType:" + this.enterType + '}');
    L8:
        String r2 = null;
        if (this.inputFloatArray == null) goto L16;
        StringBuilder r1 = new StringBuilder(", inputFloatArray.size:");
        float[] r3 = this.inputFloatArray;
        if (r3 == null) goto L13;
        Integer r4 = Integer.valueOf(r3.length);
    L14:
        r1.append(r4);
        r0.append(r1.toString());
        goto L16
    L13:
        r4 = null;
    L16:
        if (this.inputByteArray == null) goto L23;
        StringBuilder r5 = new StringBuilder(", inputByteArray.size:");
        byte[] r6 = this.inputByteArray;
        if (r6 == null) goto L20;
        Integer r7 = Integer.valueOf(r6.length);
    L21:
        r5.append(r7);
        r0.append(r5.toString());
        goto L23
    L20:
        r7 = null;
    L23:
        if (this.inputExtObj == null) goto L28;
        StringBuilder r8 = new StringBuilder(", inputExtObj:");
        Object r9 = this.inputExtObj;
        if (r9 == null) goto L27;
        r2 = r9.getClass().getSimpleName();
    L27:
        r8.append(r2);
        r0.append(r8.toString());
    L28:
        int r10 = 0;
        if (this.importantExtFeaturesMap == null) goto L36;
        StringBuilder r11 = new StringBuilder(", importantExtFeaturesMap:");
        Map<String, Object> r12 = this.importantExtFeaturesMap;
        if (r12 == null) goto L33;
        int r13 = r12.size();
    L34:
        r11.append(r13);
        r11.append('-');
        r11.append(this.importantExtFeaturesMap);
        r0.append(r11.toString());
        goto L36
    L33:
        r13 = 0;
    L36:
        if (this.inputFeaturesMap == null) goto L41;
        StringBuilder r14 = new StringBuilder(", inputFeaturesMap:");
        Map<String, Object> r15 = this.inputFeaturesMap;
        if (r15 == null) goto L40;
        r10 = r15.size();
    L40:
        r14.append(r10);
        r14.append('-');
        r14.append(this.inputFeaturesMap);
        r0.append(r14.toString());
    L41:
        r0.append("}");
        return r0.toString();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final boolean getForTrack() {
        return this.forTrack;
    }

    public final Map<String, Object> getImportantExtFeaturesMap() {
        return this.importantExtFeaturesMap;
    }

    public final byte[] getInputByteArray() {
        return this.inputByteArray;
    }

    public final Object getInputExtObj() {
        return this.inputExtObj;
    }

    public final Map<String, Object> getInputFeaturesMap() {
        return this.inputFeaturesMap;
    }

    public final float[] getInputFloatArray() {
        return this.inputFloatArray;
    }

    public final String getRunKey() {
        return this.runKey;
    }

    public SmartInputData(int r1) {
        this.capacity = r1;
    }

    public final void setCapacity(int r1) {
        this.capacity = r1;
    }

    public final void setEnterType(String r1) {
        this.enterType = r1;
    }

    public final void setForTrack(boolean r1) {
        this.forTrack = r1;
    }

    public final void setImportantExtFeaturesMap(Map<String, Object> r1) {
        this.importantExtFeaturesMap = r1;
    }

    public final void setInputByteArray(byte[] r1) {
        this.inputByteArray = r1;
    }

    public final void setInputExtObj(Object r1) {
        this.inputExtObj = r1;
    }

    public final void setInputFeaturesMap(Map<String, Object> r1) {
        this.inputFeaturesMap = r1;
    }

    public final void setInputFloatArray(float[] r1) {
        this.inputFloatArray = r1;
    }

    public final void setRunKey(String r1) {
        this.runKey = r1;
    }

    public /* synthetic */ SmartInputData(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 128;
    L5:
        this(r1);
    }
}
