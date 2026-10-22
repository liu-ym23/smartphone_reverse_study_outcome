package com.obric.memorydata.memory.ui.automemory.requirement;

import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.automemory.settings.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/requirement/MemoryRuleRequirementFormatter;", "", "<init>", "()V", "format", "", "ruleId", "", "info", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "formatLegacy", "title", Params.CONTENT, "hasStructuredContent", "", "sceneSection", "", MemoryInfoSectionEditActivity.KIND_SCENE, "infoSection", "section", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "toRuleText", EventBody.KEY_VALUE, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10716a = null;

    static {
        f10716a = new a();
    }

    private a() {
    }

    private final List<String> a(e.b r9) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L8:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(b(r9.a()), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        r8 = "具体记忆的内容";
    L14:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        r1.add(f10716a.b((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin")));
        goto L16
    L18:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L27;
        Object r5 = r14.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L20;
        r2.add(r5);
        goto L20
    L24:
        r6 = false;
        goto L25
    L27:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r15.isEmpty() == true) goto L43;
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r10 + 65306), Collection.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L32:
        if (r18.hasNext() == false) goto L35;
        r3.add("- " + ((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin")));
        goto L32
    L35:
        return CollectionsKt.plus(r16, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L43:
        return CollectionsKt.listOf(r10 + 65306);
    L11:
        r0 = false;
        goto L12
    L5:
        if (r9.b().isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }

    private final List<String> a(String r4) {
        String r3 = b(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.listOf(new String[]{"触发记忆的场景：", "- " + r3});
    L5:
        r5 = false;
        goto L6
    }

    private final String b(String r13) {
        if (r13 != null) goto L6;
        return "";
    L6:
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
    }

    public final String a(long r18, e r20) {
        Intrinsics.checkNotNullParameter(r20, "info");
        boolean r1 = true;
        List r3 = CollectionsKt.mutableListOf(new String[]{"<Rule id=" + r18 + Typography.greater});
        String r4 = b(r20.a());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r6 = true;
    L6:
        String r8 = null;
        if (r6 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
        r3.add("标题：" + r4);
    L12:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r20.b()), Collection.class, "com.obric.memorydata.plugin"));
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r20.c()), Collection.class, "com.obric.memorydata.plugin"));
        String r0 = b(r20.d());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        r8 = r0;
    L18:
        if (r8 == null) goto L20;
        r3.add("补充要求：" + r8);
    L20:
        r3.add("</Rule>");
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + '\n';
    L5:
        r6 = false;
        goto L6
    }

    public final String a(long r18, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "title");
        Intrinsics.checkNotNullParameter(r21, Params.CONTENT);
        boolean r3 = true;
        List r4 = CollectionsKt.mutableListOf(new String[]{"<Rule id=" + r18 + Typography.greater});
        String r1 = b(r20);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        String r8 = null;
        if (r5 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r4.add("标题：" + r1);
    L12:
        String r0 = b(r21);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L18;
        r8 = r0;
    L18:
        if (r8 == null) goto L20;
        r4.add("具体记忆的内容：" + r8);
    L20:
        r4.add("</Rule>");
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + '\n';
    L5:
        r5 = false;
        goto L6
    }

    public final boolean a(e r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.c().a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        return true;
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.c().b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
        return true;
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L19;
        return false;
    L19:
        return true;
    }
}
