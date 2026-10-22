package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0002'(BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v1/space/DocTabPayload;", "Ljava/io/Serializable;", "key", BuildConfig.FLAVOR, "url", IPortraitService.NAME, "docType", "source", ChameleonOpenTracker.ParamKey.APP_ID, BuildConfig.FLAVOR, "iconInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUrl", "getName", "setName", "(Ljava/lang/String;)V", "getDocType", "getSource", "getApp_id", "()J", "getIconInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "DocType", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocTabPayload implements Serializable {
    public static final a Companion = null;
    public static final String VALUE_OPAI = "OAPI";
    private final long app_id;
    private final String docType;
    private final String iconInfo;
    private final String key;
    private String name;
    private final String source;
    private final String url;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v1/space/DocTabPayload$DocType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DocType {
        public static final String BITABLE = "3";
        public static final a Companion = null;
        public static final String DOC = "1";
        public static final String DOCX = "8";
        public static final String FILE = "5";
        public static final String MINDNOTE = "4";
        public static final String SHEET = "2";
        public static final String SLIDE = "6";
        public static final String SLIDES = "11";
        public static final String UNKNOWN = "0";
        public static final String WIKI = "7";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ DocTabPayload copy$default(DocTabPayload r9, String r10, String r11, String r12, String r13, String r14, long r15, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.key;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.url;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.name;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r4 = r9.docType;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.source;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r6 = r9.app_id;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.iconInfo;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.docType;
    }

    public final String component5() {
        return this.source;
    }

    public final long component6() {
        return this.app_id;
    }

    public final String component7() {
        return this.iconInfo;
    }

    public final DocTabPayload copy(String r11, String r12, String r13, String r14, String r15, long r16, String r18) {
        return new DocTabPayload(r11, r12, r13, r14, r15, r16, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DocTabPayload) == true) goto L8;
        return false;
    L8:
        DocTabPayload r9 = (DocTabPayload) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docType, r9.docType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r9.source) == true) goto L24;
        return false;
    L24:
        if (this.app_id == r9.app_id) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iconInfo, r9.iconInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.docType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.source;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        long r16 = this.app_id;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        String r18 = this.iconInfo;
        if (r18 == null) goto L27;
        r1 = r18.hashCode();
    L27:
        return r17 + r1;
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
        return "DocTabPayload(key=" + this.key + ", url=" + this.url + ", name=" + this.name + ", docType=" + this.docType + ", source=" + this.source + ", app_id=" + this.app_id + ", iconInfo=" + this.iconInfo + ')';
    }

    public final long getApp_id() {
        return this.app_id;
    }

    public final String getDocType() {
        return this.docType;
    }

    public final String getIconInfo() {
        return this.iconInfo;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.space.doc.v1.DocTabPayload parsePbFromDocTabPayload(DocTabPayload r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "payload");
        return new com.bytedance.lark.pb.space.doc.v1.DocTabPayload.Builder().key(r2.getKey()).url(r2.getUrl()).name(r2.getName()).build();
    }

    @JvmStatic
    public static final String parsePbFromDocTabPayloadToJson(DocTabPayload r3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r3, "payload");
        JSONObject r0 = new JSONObject();
        String r1 = r3.getKey();
        if (r1 == null) goto L5;
        r0.put("key", r1);
    L5:
        String r2 = r3.getUrl();
        if (r2 == null) goto L8;
        r0.put("url", r2);
    L8:
        String r4 = r3.getName();
        if (r4 == null) goto L11;
        r0.put(IPortraitService.NAME, r4);
    L11:
        String r5 = r3.getDocType();
        if (r5 == null) goto L14;
        r0.put("docType", r5);
    L14:
        String r6 = r3.getIconInfo();
        if (r6 == null) goto L18;
        r0.put("iconInfo", r6);
    L18:
        return r0.toString();
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public DocTabPayload(String r1, String r2, String r3, String r4, String r5, long r6, String r8) {
        this.key = r1;
        this.url = r2;
        this.name = r3;
        this.docType = r4;
        this.source = r5;
        this.app_id = r6;
        this.iconInfo = r8;
    }

    public /* synthetic */ DocTabPayload(String r11, String r12, String r13, String r14, String r15, long r16, String r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 16) == 0) goto L5;
        String r6 = BuildConfig.FLAVOR;
    L7:
        if ((r19 & 32) == 0) goto L9;
        long r7 = 0;
    L11:
        if ((r19 & 64) == 0) goto L13;
        String r9 = null;
    L14:
        this(r11, r12, r13, r14, r6, r7, r9);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
