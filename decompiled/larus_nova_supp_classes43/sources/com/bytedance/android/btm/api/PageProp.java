package com.bytedance.android.btm.api;

import com.bytedance.android.btm.api.inner.Logger;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001,B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001d¨\u0006-"}, d2 = {"Lcom/bytedance/android/btm/api/PageProp;", "Ljava/io/Serializable;", "Lxc/a;", "", "save", "data", "parse", "component1", "", "component2", "component3", "component4", "component5", "btm", "auto", "singleton", "reuse", "sourceBtmToken", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getBtm", "()Ljava/lang/String;", "setBtm", "(Ljava/lang/String;)V", "Z", "getAuto", "()Z", "setAuto", "(Z)V", "getSingleton", "setSingleton", "getReuse", "setReuse", "getSourceBtmToken", "setSourceBtmToken", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;)V", "Companion", "a", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class PageProp implements Serializable, xc.a<PageProp> {
    public static final a Companion = null;
    private static final long serialVersionUID = 20220104;
    private boolean auto;
    private String btm;
    private boolean reuse;
    private boolean singleton;
    private String sourceBtmToken;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PageProp() {
        this(null, false, false, false, null, 31, null);
    }

    public static /* synthetic */ PageProp copy$default(PageProp r10, String r11, boolean r12, boolean r13, boolean r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.btm;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.auto;
    L8:
        boolean r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.singleton;
    L11:
        boolean r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.reuse;
    L14:
        boolean r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.sourceBtmToken;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.btm;
    }

    public final boolean component2() {
        return this.auto;
    }

    public final boolean component3() {
        return this.singleton;
    }

    public final boolean component4() {
        return this.reuse;
    }

    public final String component5() {
        return this.sourceBtmToken;
    }

    public final PageProp copy(String r10, boolean r11, boolean r12, boolean r13, String r14) {
        return new PageProp(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof PageProp) == false) goto L16;
        PageProp r11 = (PageProp) r10;
        if (Intrinsics.areEqual(this.btm, r11.btm) == true) goto L8;
        return false;
    L8:
        if (this.auto == r11.auto) goto L10;
        return false;
    L10:
        if (this.singleton == r11.singleton) goto L12;
        return false;
    L12:
        if (this.reuse == r11.reuse) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sourceBtmToken, r11.sourceBtmToken) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.btm;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.auto;
        ?? r13 = 1;
        ?? r14 = r12;
        if (r12 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.singleton;
        ?? r17 = r16;
        if (r16 == false) goto L12;
        r17 = 1;
    L12:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.reuse;
        if (r19 == true) goto L16;
        r13 = r19;
    L16:
        int r20 = (r18 + r13) * 31;
        String r21 = this.sourceBtmToken;
        if (r21 == null) goto L20;
        r1 = r21.hashCode();
    L20:
        return r20 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "PageProp(btm=" + this.btm + ", auto=" + this.auto + ", singleton=" + this.singleton + ", reuse=" + this.reuse + ", sourceBtmToken=" + this.sourceBtmToken + ")";
    }

    public String save() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("btm", this.btm);     // Catch: Throwable -> L6
        r0.putOpt("auto", Boolean.valueOf(this.auto));     // Catch: Throwable -> L6
        r0.putOpt("singleton", Boolean.valueOf(this.singleton));     // Catch: Throwable -> L6
        r0.putOpt("reuse", Boolean.valueOf(this.reuse));     // Catch: Throwable -> L6
        r0.putOpt("source_btm_token", this.sourceBtmToken);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public final boolean getAuto() {
        return this.auto;
    }

    public final String getBtm() {
        return this.btm;
    }

    public final boolean getReuse() {
        return this.reuse;
    }

    public final boolean getSingleton() {
        return this.singleton;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public PageProp parse(String r10) {
        JSONObject r0 = new JSONObject(r10);     // Catch: Exception -> L4
        this.btm = r0.optString("btm");     // Catch: Exception -> L4
        this.auto = r0.optBoolean("auto");     // Catch: Exception -> L4
        this.singleton = r0.optBoolean("singleton");     // Catch: Exception -> L4
        this.reuse = r0.optBoolean("reuse");     // Catch: Exception -> L4
        this.sourceBtmToken = r0.optString("source_btm_token");     // Catch: Exception -> L4
    L8:
        return this;
    L4:
        e = move-exception;
        Logger r1 = Logger.c;
        Function0<String> r11 = new AnonymousClass1(e);
        r1.getClass();
        com.bytedance.android.btm.api.inner.f r12 = (com.bytedance.android.btm.api.inner.f) Logger.b.getValue(r1, Logger.a[0]);
        if (r12 == null) goto L8;
        r12.a(r11);
        goto L8
    }

    public final void setAuto(boolean r1) {
        this.auto = r1;
    }

    public final void setBtm(String r1) {
        this.btm = r1;
    }

    public final void setReuse(boolean r1) {
        this.reuse = r1;
    }

    public final void setSingleton(boolean r1) {
        this.singleton = r1;
    }

    public final void setSourceBtmToken(String r1) {
        this.sourceBtmToken = r1;
    }

    /* JADX INFO: renamed from: parse, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m585parse(String r1) {
        return parse(r1);
    }

    public PageProp(String r1, boolean r10, boolean r11, boolean r12, String r13) {
        this.btm = r1;
        this.auto = r10;
        this.singleton = r11;
        this.reuse = r12;
        this.sourceBtmToken = r13;
    }

    public /* synthetic */ PageProp(String r10, boolean r11, boolean r12, boolean r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r15 & 2) == 0) goto L8;
        boolean r17 = true;
    L9:
        boolean r0 = false;
        if ((r15 & 4) == 0) goto L12;
        boolean r1 = false;
    L14:
        if ((r15 & 8) != 0) goto L18;
        r0 = r13;
    L18:
        if ((r15 & 16) == 0) goto L20;
        r14 = null;
    L20:
        String r18 = r14;
        this(r10, r17, r1, r0, r18);
        return;
    L12:
        r1 = r12;
        goto L14
    L8:
        r17 = r11;
        goto L9
    }
}
