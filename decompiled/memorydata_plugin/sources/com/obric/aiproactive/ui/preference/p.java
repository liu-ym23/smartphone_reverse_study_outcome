package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceRuleMapper;", "", "<init>", "()V", "toGeneratedRules", "", "", "state", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "toGeneratedRule", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOption;", "input", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f6788a = null;

    static {
        f6788a = new p();
    }

    private p() {
    }

    private final String a(m r3, String r4) {
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3.f() == false) goto L8;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return null;
    L8:
        if (r3.g() == true) goto L10;
        String r5 = r3.d();
        if (r5 == null) goto L17;
        return r5;
    L17:
        String r6 = r3.e();
        if (r6 != null) goto L20;
        return null;
    L20:
        return r6 + r2;
    L10:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        return r2;
    L13:
        return null;
    }

    public final List<String> a(j r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L16;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(r9.next(), o.class, "com.obric.memorydata.plugin")).d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        m r5 = (m) ZeusTransformUtils.preCheckCast(r4.next(), m.class, "com.obric.memorydata.plugin");
        if (r8.c(r5.a()) == true) goto L11;
        String r6 = null;
    L12:
        if (r6 == null) goto L7;
        r3.add(r6);
        goto L7
    L11:
        r6 = f6788a.a(r5, r8.d(r5.a()));
        goto L12
    L14:
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }
}
