package com.ss.android.lark.chameleon.api;

import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J)\u00102\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000eHÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010HÆ\u0003J·\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010HÆ\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\b\u0010:\u001a\u00020\u0006H\u0016R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "Ljava/io/Serializable;", "enable", BuildConfig.FLAVOR, "necessaryCookieKeys", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "filetype", "rootHtml", "pathRewrites", "commonTemplateVars", "mapPattern", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBizTemplateVars", BuildConfig.FLAVOR, "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/Map;)V", "getCommonTemplateVars", "()Ljava/util/ArrayList;", "setCommonTemplateVars", "(Ljava/util/ArrayList;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getFiletype", "setFiletype", "getGetBizTemplateVars", "()Ljava/util/Map;", "setGetBizTemplateVars", "(Ljava/util/Map;)V", "getMapPattern", "()Ljava/util/HashMap;", "setMapPattern", "(Ljava/util/HashMap;)V", "getNecessaryCookieKeys", "setNecessaryCookieKeys", "getPathRewrites", "()Ljava/lang/String;", "setPathRewrites", "(Ljava/lang/String;)V", "getRootHtml", "setRootHtml", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResInterceptConfig implements Serializable {
    private ArrayList<String> commonTemplateVars;
    private boolean enable;
    private ArrayList<String> filetype;
    private Map<String, String> getBizTemplateVars;
    private HashMap<String, String> mapPattern;
    private ArrayList<String> necessaryCookieKeys;
    private String pathRewrites;
    private String rootHtml;

    public ResInterceptConfig() {
        this(false, null, null, null, null, null, null, null, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResInterceptConfig copy$default(ResInterceptConfig r9, boolean r10, ArrayList r11, ArrayList r12, String r13, String r14, ArrayList r15, HashMap r16, Map r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r2 = r9.enable;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ArrayList r3 = r9.necessaryCookieKeys;
    L11:
        if ((r18 & 4) == 0) goto L13;
        ArrayList r4 = r9.filetype;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.rootHtml;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.pathRewrites;
    L23:
        if ((r18 & 32) == 0) goto L25;
        ArrayList r7 = r9.commonTemplateVars;
    L27:
        if ((r18 & 64) == 0) goto L29;
        HashMap r8 = r9.mapPattern;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Map r1 = r9.getBizTemplateVars;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.enable;
    }

    public final ArrayList<String> component2() {
        return this.necessaryCookieKeys;
    }

    public final ArrayList<String> component3() {
        return this.filetype;
    }

    public final String component4() {
        return this.rootHtml;
    }

    public final String component5() {
        return this.pathRewrites;
    }

    public final ArrayList<String> component6() {
        return this.commonTemplateVars;
    }

    public final HashMap<String, String> component7() {
        return this.mapPattern;
    }

    public final Map<String, String> component8() {
        return this.getBizTemplateVars;
    }

    public final ResInterceptConfig copy(boolean r11, ArrayList<String> r12, ArrayList<String> r13, String r14, String r15, ArrayList<String> r16, HashMap<String, String> r17, Map<String, String> r18) {
        Intrinsics.checkNotNullParameter(r12, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r13, "filetype");
        Intrinsics.checkNotNullParameter(r14, "rootHtml");
        Intrinsics.checkNotNullParameter(r15, "pathRewrites");
        Intrinsics.checkNotNullParameter(r16, "commonTemplateVars");
        return new ResInterceptConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResInterceptConfig) == true) goto L8;
        return false;
    L8:
        ResInterceptConfig r6 = (ResInterceptConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.necessaryCookieKeys, r6.necessaryCookieKeys) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filetype, r6.filetype) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rootHtml, r6.rootHtml) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pathRewrites, r6.pathRewrites) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.commonTemplateVars, r6.commonTemplateVars) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mapPattern, r6.mapPattern) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.getBizTemplateVars, r6.getBizTemplateVars) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((((((((((r1 * 31) + this.necessaryCookieKeys.hashCode()) * 31) + this.filetype.hashCode()) * 31) + this.rootHtml.hashCode()) * 31) + this.pathRewrites.hashCode()) * 31) + this.commonTemplateVars.hashCode()) * 31;
        HashMap<String, String> r3 = this.mapPattern;
        int r4 = 0;
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r2 + r5) * 31;
        Map<String, String> r7 = this.getBizTemplateVars;
        if (r7 == null) goto L14;
        r4 = r7.hashCode();
    L14:
        return r6 + r4;
    L8:
        r5 = r3.hashCode();
        goto L9
    }

    public String toString() {
        return "ResInterceptConfig(enable=" + this.enable + ", necessaryCookieKeys=" + this.necessaryCookieKeys + ", filetype=" + this.filetype + ", rootHtml='" + this.rootHtml + "', pathRewrites='" + this.pathRewrites + "', commonTemplateVars=" + this.commonTemplateVars + ", mapPattern=" + this.mapPattern + ')';
    }

    public final ArrayList<String> getCommonTemplateVars() {
        return this.commonTemplateVars;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ArrayList<String> getFiletype() {
        return this.filetype;
    }

    public final Map<String, String> getGetBizTemplateVars() {
        return this.getBizTemplateVars;
    }

    public final HashMap<String, String> getMapPattern() {
        return this.mapPattern;
    }

    public final ArrayList<String> getNecessaryCookieKeys() {
        return this.necessaryCookieKeys;
    }

    public final String getPathRewrites() {
        return this.pathRewrites;
    }

    public final String getRootHtml() {
        return this.rootHtml;
    }

    public final void setCommonTemplateVars(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commonTemplateVars = r2;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public final void setFiletype(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.filetype = r2;
    }

    public final void setGetBizTemplateVars(Map<String, String> r1) {
        this.getBizTemplateVars = r1;
    }

    public final void setMapPattern(HashMap<String, String> r1) {
        this.mapPattern = r1;
    }

    public final void setNecessaryCookieKeys(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.necessaryCookieKeys = r2;
    }

    public final void setPathRewrites(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pathRewrites = r2;
    }

    public final void setRootHtml(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootHtml = r2;
    }

    public ResInterceptConfig(boolean r2, ArrayList<String> r3, ArrayList<String> r4, String r5, String r6, ArrayList<String> r7, HashMap<String, String> r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r3, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r4, "filetype");
        Intrinsics.checkNotNullParameter(r5, "rootHtml");
        Intrinsics.checkNotNullParameter(r6, "pathRewrites");
        Intrinsics.checkNotNullParameter(r7, "commonTemplateVars");
        this.enable = r2;
        this.necessaryCookieKeys = r3;
        this.filetype = r4;
        this.rootHtml = r5;
        this.pathRewrites = r6;
        this.commonTemplateVars = r7;
        this.mapPattern = r8;
        this.getBizTemplateVars = r9;
    }

    public /* synthetic */ ResInterceptConfig(boolean r10, ArrayList r11, ArrayList r12, String r13, String r14, ArrayList r15, HashMap r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ArrayList r2 = new ArrayList();
    L11:
        if ((r18 & 4) == 0) goto L13;
        ArrayList r3 = new ArrayList();
    L14:
        int r4 = r18 & 8;
        String r5 = BuildConfig.FLAVOR;
        if (r4 == 0) goto L17;
        String r6 = BuildConfig.FLAVOR;
    L19:
        if ((r18 & 16) != 0) goto L23;
        r5 = r14;
    L23:
        if ((r18 & 32) == 0) goto L25;
        ArrayList r7 = new ArrayList();
    L26:
        Map r8 = null;
        if ((r18 & 64) == 0) goto L29;
        HashMap r9 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r8 = r17;
    L34:
        this(r1, r2, r3, r6, r5, r7, r9, r8);
        return;
    L29:
        r9 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L26
    L17:
        r6 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L14
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
