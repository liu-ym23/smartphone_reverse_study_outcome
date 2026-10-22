package com.ss.ugc.clientai.core.api;

import android.text.TextUtils;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 52\u00020\u0001:\u00016B\u0011\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b4\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0018\u001a\u00020\bH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010)R2\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartOutputData;", "", "", "success", "", "labelScore", "()Ljava/lang/Float;", "", "", "outMap", TabAppInfo.IMAGE_JSON_KEY, "getExtData", "taskName", "subTaskOutData", "groupName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subGroupTaskOutData", "target", "subGroupTaskTargetOutData", "Lorg/json/JSONObject;", "outputs", "", "mergeFrom", "toString", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "scoreMap", "Ljava/util/Map;", "getScoreMap", "()Ljava/util/Map;", "setScoreMap", "(Ljava/util/Map;)V", "value", "Ljava/lang/Float;", "getValue", "setValue", "(Ljava/lang/Float;)V", "extOutMap", "getExtOutMap", "setExtOutMap", "", "errorCode", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "<init>", "Companion", "a", "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartOutputData {
    public static final a Companion = null;
    private int errorCode;
    private Map<String, Object> extOutMap;
    private String label;
    private Map<String, Float> scoreMap;
    private Float value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SmartOutputData() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final Float labelScore() {
        String r0 = this.label;
        if (r0 == null) goto L8;
        Map<String, Float> r2 = this.scoreMap;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.get(r0);
    L8:
        return null;
    }

    public final Map<String, Object> outMap() {
        Map<String, Object> r0 = this.extOutMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        HashMap r1 = new HashMap();
        this.extOutMap = r1;
        return r1;
    }

    public final boolean success() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{success:" + success() + ", errorCode:" + this.errorCode);
        if (this.label == null) goto L6;
        r0.append(", label:" + this.label);
    L6:
        if (this.scoreMap == null) goto L9;
        r0.append(", scoreMap=" + this.scoreMap);
    L9:
        if (this.value == null) goto L12;
        r0.append(", value=" + this.value);
    L12:
        if (this.extOutMap == null) goto L14;
        r0.append(", extOutMap=" + this.extOutMap);
    L14:
        r0.append("}");
        return r0.toString();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Map<String, Object> getExtOutMap() {
        return this.extOutMap;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Map<String, Float> getScoreMap() {
        return this.scoreMap;
    }

    public final Float getValue() {
        return this.value;
    }

    public SmartOutputData(int r1) {
        this.errorCode = r1;
    }

    public final Object getExtData(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Map<String, Object> r0 = this.extOutMap;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public final void mergeFrom(JSONObject r7) {
        if (r7 == null) goto L27;
        Object r0 = r7.opt("label");
        if ((r0 instanceof String) == false) goto L6;
        this.label = (String) r0;
    L6:
        Object r1 = r7.opt("score_map");
        if ((r1 instanceof JSONObject) == false) goto L13;
        HashMap r2 = new HashMap();
        JSONObject r3 = (JSONObject) r1;
        Iterator<String> r4 = r3.keys();
    L10:
        if (r4.hasNext() == false) goto L12;
        String r5 = r4.next();
        r2.put(r5, Float.valueOf((float) r3.optDouble(r5, 0.0d)));
        goto L10
    L12:
        this.scoreMap = r2;
    L13:
        Object r6 = r7.opt("value");
        if ((r6 instanceof Number) == false) goto L16;
        this.value = Float.valueOf(((Number) r6).floatValue());
    L16:
        Object r8 = r7.opt("result");
        if ((r8 instanceof Number) == false) goto L19;
        this.value = Float.valueOf(((Number) r8).floatValue());
    L19:
        Object r9 = r7.opt("binaryValue");
        if ((r9 instanceof Number) == false) goto L22;
        this.value = Float.valueOf(((Number) r9).floatValue());
    L22:
        Map<String, Object> r10 = outMap();
        Iterator<String> r11 = r7.keys();
    L24:
        if (r11.hasNext() == false) goto L26;
        String r12 = r11.next();
        r10.put(r12, r7.opt(r12));
        goto L24
    L26:
        this.errorCode = 0;
        return;
    L27:
        this.errorCode = -5;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final void setExtOutMap(Map<String, Object> r1) {
        this.extOutMap = r1;
    }

    public final void setLabel(String r1) {
        this.label = r1;
    }

    public final void setScoreMap(Map<String, Float> r1) {
        this.scoreMap = r1;
    }

    public final void setValue(Float r1) {
        this.value = r1;
    }

    public final ArrayList<SmartOutputData> subGroupTaskOutData(String r7) {
        Intrinsics.checkNotNullParameter(r7, "groupName");
        Map<String, Object> r0 = this.extOutMap;
        if (r0 == null) goto L29;
        Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
        ArrayList<SmartOutputData> r2 = null;
    L6:
        if (r1.hasNext() == false) goto L21;
        Object r3 = r1.next().getValue();
        if ((r3 instanceof SmartOutputData) == true) goto L10;
        r3 = null;
    L10:
        SmartOutputData r4 = (SmartOutputData) r3;
        if (r4 == null) goto L6;
        Object r5 = r4.getExtData(INotificationHitPoint.ChatType.CHAT_TYPE_GROUP);
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        if (TextUtils.equals(r7, (String) r5) == false) goto L6;
        if (r2 != null) goto L19;
        r2 = new ArrayList();
    L19:
        r2.add(r4);
        goto L6
    L21:
        return r2;
    L29:
        return null;
    }

    public final SmartOutputData subTaskOutData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskName");
        Map<String, Object> r0 = this.extOutMap;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r4 = r0.get(r3);
    L7:
        if ((r4 instanceof SmartOutputData) == false) goto L11;
        r1 = r4;
    L11:
        return (SmartOutputData) r1;
    L5:
        r4 = null;
        goto L7
    }

    public final SmartOutputData subGroupTaskTargetOutData(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "groupName");
        Intrinsics.checkNotNullParameter(r7, "target");
        ArrayList<SmartOutputData> r8 = subGroupTaskOutData(r6);
        if (r8 == null) goto L13;
        Iterator<SmartOutputData> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L13;
        SmartOutputData r2 = r9.next();
        Object r3 = r2.getExtData("target");
        if ((r3 instanceof String) == true) goto L11;
        r3 = null;
    L11:
        if (TextUtils.equals(r7, (String) r3) == false) goto L6;
        return r2;
    L13:
        return null;
    }

    public /* synthetic */ SmartOutputData(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = -999;
    L5:
        this(r1);
    }
}
