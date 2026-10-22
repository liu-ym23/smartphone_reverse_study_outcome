package com.larus.bmhome.chat.model;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u0003J\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u009d\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "", "imageUriString", "", "mode", "Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", ChatDraftItem.TYPE_TEXT, "scene", "sceneForText", "enterMethod", "previousPage", "contentSource", "eventExt", "", "msgExt", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getImageUriString", "()Ljava/lang/String;", "getMode", "()Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", "getText", "getScene", "getSceneForText", "getEnterMethod", "getPreviousPage", "getContentSource", "getEventExt", "()Ljava/util/Map;", "getMsgExt", "toJson", "toMultimodalEventExt", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImportedImageRouteParam {
    public static final a Companion = null;

    @SerializedName("content_source")
    private final String contentSource;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("event_ext")
    private final Map<String, String> eventExt;

    @SerializedName("image_uri_string")
    private final String imageUriString;

    @SerializedName("mode")
    private final ImportedImageRouteMode mode;

    @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
    private final Map<String, String> msgExt;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("scene_for_text")
    private final String sceneForText;

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private final String text;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImportedImageRouteParam() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImportedImageRouteParam copy$default(ImportedImageRouteParam r11, String r12, ImportedImageRouteMode r13, String r14, String r15, String r16, String r17, String r18, String r19, Map r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.imageUriString;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ImportedImageRouteMode r3 = r11.mode;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.text;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.scene;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.sceneForText;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.enterMethod;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.previousPage;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.contentSource;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Map r10 = r11.eventExt;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Map r1 = r11.msgExt;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.imageUriString;
    }

    public final Map<String, String> component10() {
        return this.msgExt;
    }

    public final ImportedImageRouteMode component2() {
        return this.mode;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.scene;
    }

    public final String component5() {
        return this.sceneForText;
    }

    public final String component6() {
        return this.enterMethod;
    }

    public final String component7() {
        return this.previousPage;
    }

    public final String component8() {
        return this.contentSource;
    }

    public final Map<String, String> component9() {
        return this.eventExt;
    }

    public final ImportedImageRouteParam copy(String r13, ImportedImageRouteMode r14, String r15, String r16, String r17, String r18, String r19, String r20, Map<String, String> r21, Map<String, String> r22) {
        return new ImportedImageRouteParam(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImportedImageRouteParam) == true) goto L8;
        return false;
    L8:
        ImportedImageRouteParam r6 = (ImportedImageRouteParam) r5;
        if (Intrinsics.areEqual(this.imageUriString, r6.imageUriString) == true) goto L12;
        return false;
    L12:
        if (this.mode == r6.mode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sceneForText, r6.sceneForText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.contentSource, r6.contentSource) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.eventExt, r6.eventExt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.msgExt, r6.msgExt) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.imageUriString;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImportedImageRouteMode r4 = this.mode;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.text;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.scene;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sceneForText;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.enterMethod;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.previousPage;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.contentSource;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, String> r25 = this.eventExt;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.msgExt;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImportedImageRouteParam(imageUriString=" + this.imageUriString + ", mode=" + this.mode + ", text=" + this.text + ", scene=" + this.scene + ", sceneForText=" + this.sceneForText + ", enterMethod=" + this.enterMethod + ", previousPage=" + this.previousPage + ", contentSource=" + this.contentSource + ", eventExt=" + this.eventExt + ", msgExt=" + this.msgExt + ')';
    }

    public final String toJson() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public final Map<String, String> toMultimodalEventExt() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = this.scene;
        if (r1 == null) goto L5;
        String r2 = (String) r0.put("scene", r1);
    L5:
        String r3 = this.enterMethod;
        String r4 = null;
        boolean r5 = true;
        if (r3 != null) goto L8;
    L16:
        String r6 = this.previousPage;
        if (r6 != null) goto L19;
    L27:
        String r7 = this.contentSource;
        if (r7 != null) goto L30;
    L37:
        Map<String, String> r8 = this.eventExt;
        if (r8 == null) goto L45;
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L41:
        if (r9.hasNext() == false) goto L45;
        Map.Entry<String, String> r10 = r9.next();
        String r11 = r10.getKey();
        String r12 = r10.getValue();
        if (r12 == null) goto L41;
        r0.put(r11, r12);
    L45:
        return r0;
    L30:
        if (r7.length() > 0) goto L33;
        r5 = false;
    L33:
        if (r5 == false) goto L35;
        r4 = r7;
    L35:
        if (r4 == null) goto L37;
        String r13 = (String) r0.put("content_source", r4);
        goto L37
    L19:
        if (r6.length() <= 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L27;
        String r15 = (String) r0.put("previous_page", r6);
        goto L27
    L21:
        r14 = false;
        goto L22
    L8:
        if (r3.length() <= 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        r0.put("enter_method", r3);
        String r17 = (String) r0.put("enter_method_trace", r3);
        goto L16
    L10:
        r16 = false;
        goto L11
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Map<String, String> getEventExt() {
        return this.eventExt;
    }

    public final String getImageUriString() {
        return this.imageUriString;
    }

    public final ImportedImageRouteMode getMode() {
        return this.mode;
    }

    public final Map<String, String> getMsgExt() {
        return this.msgExt;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSceneForText() {
        return this.sceneForText;
    }

    public final String getText() {
        return this.text;
    }

    public ImportedImageRouteParam(String r1, ImportedImageRouteMode r2, String r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9, Map<String, String> r10) {
        this.imageUriString = r1;
        this.mode = r2;
        this.text = r3;
        this.scene = r4;
        this.sceneForText = r5;
        this.enterMethod = r6;
        this.previousPage = r7;
        this.contentSource = r8;
        this.eventExt = r9;
        this.msgExt = r10;
    }

    public /* synthetic */ ImportedImageRouteParam(String r12, ImportedImageRouteMode r13, String r14, String r15, String r16, String r17, String r18, String r19, Map r20, Map r21, int r22, DefaultConstructorMarker r23) {
        Map r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ImportedImageRouteMode r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = "album";
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = "router_auto_send";
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Map r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
