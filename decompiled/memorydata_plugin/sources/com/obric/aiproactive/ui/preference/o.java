package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "", "title", "", "subtitle", "selectionMode", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceSelectionMode;", "options", "", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOption;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/ui/preference/GuidedPreferenceSelectionMode;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getSelectionMode", "()Lcom/obric/aiproactive/ui/preference/GuidedPreferenceSelectionMode;", "getOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6787b;
    private final GuidedPreferenceSelectionMode c;
    private final List<m> d;

    public o(String r3, String r4, GuidedPreferenceSelectionMode r5, List<m> r6) {
        List<m> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        Intrinsics.checkNotNullParameter(r5, "selectionMode");
        Intrinsics.checkNotNullParameter(r7, "options");
        this.f6786a = r3;
        this.f6787b = r4;
        this.c = r5;
        this.d = r7;
    }

    public final String a() {
        return this.f6786a;
    }

    public final String b() {
        return this.f6787b;
    }

    public final GuidedPreferenceSelectionMode c() {
        return this.c;
    }

    public final List<m> d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6786a, r6.f6786a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6787b, r6.f6787b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f6786a.hashCode() * 31) + this.f6787b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "GuidedPreferencePage(title=" + this.f6786a + ", subtitle=" + this.f6787b + ", selectionMode=" + this.c + ", options=" + this.d + ')';
    }
}
