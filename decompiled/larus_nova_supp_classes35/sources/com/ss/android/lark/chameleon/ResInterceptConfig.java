package com.ss.android.lark.chameleon;

import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B¨\u0001\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00123\b\u0002\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010+\u001a\u00020\u0000J\b\u0010,\u001a\u00020\u0004H\u0016J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J4\u00102\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003Jª\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u000523\b\u0002\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018RE\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00069"}, d2 = {"Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "Ljava/io/Serializable;", "necessaryCookieKeys", "Ljava/util/ArrayList;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "filetype", "rootHtml", "pathRewrites", "commonTemplateVars", "getBizTemplateVars", "Lkotlin/Function1;", "Lcom/ss/android/lark/vfs/VFSPath;", "Lkotlin/ParameterName;", IPortraitService.NAME, "vfsPath", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "serviceWorkerEnable", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;Z)V", "getNecessaryCookieKeys", "()Ljava/util/ArrayList;", "setNecessaryCookieKeys", "(Ljava/util/ArrayList;)V", "getFiletype", "setFiletype", "getRootHtml", "()Ljava/lang/String;", "setRootHtml", "(Ljava/lang/String;)V", "getPathRewrites", "setPathRewrites", "getCommonTemplateVars", "setCommonTemplateVars", "getGetBizTemplateVars", "()Lkotlin/jvm/functions/Function1;", "setGetBizTemplateVars", "(Lkotlin/jvm/functions/Function1;)V", "getServiceWorkerEnable", "()Z", "setServiceWorkerEnable", "(Z)V", "copy", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "equals", "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResInterceptConfig implements Serializable {
    private ArrayList<String> commonTemplateVars;
    private ArrayList<String> filetype;
    private Function1<? super VFSPath, ? extends Map<String, String>> getBizTemplateVars;
    private ArrayList<String> necessaryCookieKeys;
    private String pathRewrites;
    private String rootHtml;
    private boolean serviceWorkerEnable;

    public ResInterceptConfig() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResInterceptConfig copy$default(ResInterceptConfig r5, ArrayList r6, ArrayList r7, String r8, String r9, ArrayList r10, Function1 r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.necessaryCookieKeys;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.filetype;
    L8:
        ArrayList r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.rootHtml;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.pathRewrites;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.commonTemplateVars;
    L17:
        ArrayList r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.getBizTemplateVars;
    L20:
        Function1 r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.serviceWorkerEnable;
    L23:
        ArrayList r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final ArrayList<String> component1() {
        return this.necessaryCookieKeys;
    }

    public final ArrayList<String> component2() {
        return this.filetype;
    }

    public final String component3() {
        return this.rootHtml;
    }

    public final String component4() {
        return this.pathRewrites;
    }

    public final ArrayList<String> component5() {
        return this.commonTemplateVars;
    }

    public final Function1<VFSPath, Map<String, String>> component6() {
        return this.getBizTemplateVars;
    }

    public final boolean component7() {
        return this.serviceWorkerEnable;
    }

    public final ResInterceptConfig copy(ArrayList<String> r10, ArrayList<String> r11, String r12, String r13, ArrayList<String> r14, Function1<? super VFSPath, ? extends Map<String, String>> r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r11, "filetype");
        Intrinsics.checkNotNullParameter(r12, "rootHtml");
        Intrinsics.checkNotNullParameter(r13, "pathRewrites");
        Intrinsics.checkNotNullParameter(r14, "commonTemplateVars");
        return new ResInterceptConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResInterceptConfig) == true) goto L8;
        return false;
    L8:
        ResInterceptConfig r6 = (ResInterceptConfig) r5;
        if (Intrinsics.areEqual(this.necessaryCookieKeys, r6.necessaryCookieKeys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filetype, r6.filetype) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootHtml, r6.rootHtml) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pathRewrites, r6.pathRewrites) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.commonTemplateVars, r6.commonTemplateVars) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.getBizTemplateVars, r6.getBizTemplateVars) == true) goto L27;
        return false;
    L27:
        if (this.serviceWorkerEnable == r6.serviceWorkerEnable) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.necessaryCookieKeys.hashCode() * 31) + this.filetype.hashCode()) * 31) + this.rootHtml.hashCode()) * 31) + this.pathRewrites.hashCode()) * 31) + this.commonTemplateVars.hashCode()) * 31;
        Function1<? super VFSPath, ? extends Map<String, String>> r1 = this.getBizTemplateVars;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.serviceWorkerEnable == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final ResInterceptConfig copy() {
        return new ResInterceptConfig(new ArrayList(this.necessaryCookieKeys), new ArrayList(this.filetype), this.rootHtml, this.pathRewrites, new ArrayList(this.commonTemplateVars), this.getBizTemplateVars, this.serviceWorkerEnable);
    }

    public String toString() {
        return "ResInterceptConfig(filetype=" + this.filetype + ", rootHtml='" + this.rootHtml + "', pathRewrites='" + this.pathRewrites + "', commonTemplateVars=" + this.commonTemplateVars + ", serviceWorkerEnable=" + this.serviceWorkerEnable + ')';
    }

    public final ArrayList<String> getCommonTemplateVars() {
        return this.commonTemplateVars;
    }

    public final ArrayList<String> getFiletype() {
        return this.filetype;
    }

    public final Function1<VFSPath, Map<String, String>> getGetBizTemplateVars() {
        return this.getBizTemplateVars;
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

    public final boolean getServiceWorkerEnable() {
        return this.serviceWorkerEnable;
    }

    public final void setCommonTemplateVars(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commonTemplateVars = r2;
    }

    public final void setFiletype(ArrayList<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.filetype = r2;
    }

    public final void setGetBizTemplateVars(Function1<? super VFSPath, ? extends Map<String, String>> r1) {
        this.getBizTemplateVars = r1;
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

    public final void setServiceWorkerEnable(boolean r1) {
        this.serviceWorkerEnable = r1;
    }

    public ResInterceptConfig(ArrayList<String> r2, ArrayList<String> r3, String r4, String r5, ArrayList<String> r6, Function1<? super VFSPath, ? extends Map<String, String>> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r3, "filetype");
        Intrinsics.checkNotNullParameter(r4, "rootHtml");
        Intrinsics.checkNotNullParameter(r5, "pathRewrites");
        Intrinsics.checkNotNullParameter(r6, "commonTemplateVars");
        this.necessaryCookieKeys = r2;
        this.filetype = r3;
        this.rootHtml = r4;
        this.pathRewrites = r5;
        this.commonTemplateVars = r6;
        this.getBizTemplateVars = r7;
        this.serviceWorkerEnable = r8;
    }

    public /* synthetic */ ResInterceptConfig(ArrayList r6, ArrayList r7, String r8, String r9, ArrayList r10, Function1 r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = new ArrayList();
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = new ArrayList();
    L8:
        ArrayList r15 = r7;
        int r16 = r13 & 4;
        String r0 = com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
        if (r16 == 0) goto L11;
        String r1 = com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
    L13:
        if ((r13 & 8) != 0) goto L17;
        r0 = r9;
    L17:
        if ((r13 & 16) == 0) goto L19;
        r10 = new ArrayList();
    L19:
        ArrayList r2 = r10;
        if ((r13 & 32) == 0) goto L22;
        r11 = null;
    L22:
        Function1 r3 = r11;
        if ((r13 & 64) == 0) goto L25;
        boolean r4 = false;
    L26:
        this(r6, r15, r1, r0, r2, r3, r4);
        return;
    L25:
        r4 = r12;
        goto L26
    L11:
        r1 = r8;
        goto L13
    }
}
