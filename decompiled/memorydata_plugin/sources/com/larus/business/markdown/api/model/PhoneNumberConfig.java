package com.larus.business.markdown.api.model;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BB\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003JF\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "", "enableHighlight", "", "phoneRegex", "", "linkGenerator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "phoneNumber", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getEnableHighlight", "()Z", "getLinkGenerator", "()Lkotlin/jvm/functions/Function1;", "getPhoneRegex", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberConfig {
    private final boolean enableHighlight;
    private final Function1<String, String> linkGenerator;
    private final String phoneRegex;

    public PhoneNumberConfig() {
        this(false, null, null, 7, null);
    }

    public PhoneNumberConfig(boolean r3, String r4, Function1<? super String, String> r5) {
        Function1<String, String> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        this.enableHighlight = r3;
        this.phoneRegex = r4;
        this.linkGenerator = r6;
    }

    public /* synthetic */ PhoneNumberConfig(boolean r2, String r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = null;
    L11:
        this(r2, r3, r7);
    }

    public static /* synthetic */ PhoneNumberConfig copy$default(PhoneNumberConfig r1, boolean r2, String r3, Function1 r4, int r5, Object r6) {
        Function1<String, String> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.enableHighlight;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.phoneRegex;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.linkGenerator;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final boolean component1() {
        return this.enableHighlight;
    }

    public final String component2() {
        return this.phoneRegex;
    }

    public final Function1<String, String> component3() {
        return this.linkGenerator;
    }

    public final PhoneNumberConfig copy(boolean r2, String r3, Function1<? super String, String> r4) {
        return new PhoneNumberConfig(r2, r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhoneNumberConfig.class) == true) goto L8;
        return false;
    L8:
        PhoneNumberConfig r6 = (PhoneNumberConfig) ZeusTransformUtils.preCheckCast(r5, PhoneNumberConfig.class, "com.obric.memorydata.plugin");
        if (this.enableHighlight == r6.enableHighlight) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneRegex, r6.phoneRegex) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.linkGenerator, r6.linkGenerator) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean getEnableHighlight() {
        return this.enableHighlight;
    }

    public final Function1<String, String> getLinkGenerator() {
        return this.linkGenerator;
    }

    public final String getPhoneRegex() {
        return this.phoneRegex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.enableHighlight;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.phoneRegex;
        int r4 = 0;
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r2 + r5) * 31;
        Function1<String, String> r7 = this.linkGenerator;
        if (r7 == null) goto L14;
        r4 = r7.hashCode();
    L14:
        return r6 + r4;
    L8:
        r5 = r3.hashCode();
        goto L9
    }

    public String toString() {
        return "PhoneNumberConfig(enableHighlight=" + this.enableHighlight + ", phoneRegex=" + this.phoneRegex + ", linkGenerator=" + this.linkGenerator + ')';
    }
}
