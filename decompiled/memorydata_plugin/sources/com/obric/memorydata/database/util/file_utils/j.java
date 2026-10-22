package com.obric.memorydata.database.util.file_utils;

import android.util.JsonWriter;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u0004\u0018\u00010\u0005J1\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0002J5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010!J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\bJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0006\u0010&\u001a\u00020\u000fJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0012\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "", "<init>", "()V", "virtualRoot", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "nodes", "", "", "nextId", "getVirtualRoot", "addNode", "type", "Lcom/obric/memorydata/database/util/file_utils/NodeType;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "level", "parentId", "(Lcom/obric/memorydata/database/util/file_utils/NodeType;Ljava/lang/String;ILjava/lang/Integer;)Lcom/obric/memorydata/database/util/file_utils/DocNode;", "shouldSplitNode", "", "splitContentNode", "", "originalId", "(ILcom/obric/memorydata/database/util/file_utils/NodeType;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "splitSentences", "splitTextBySemantics", "maxTokenLength", "splitByPhrases", "maxToken", "findNextParagraph", "splitByTokenSafe", "getChildren", "(Ljava/lang/Integer;)Ljava/util/List;", "getNode", OaidModel.KEY_ID, "getAllNodes", "getRealNodes", "toDocTreeJson", "writeNodeJson", "", "writer", "Landroid/util/JsonWriter;", "node", "toTreeString", "maxLines", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f9656b;
    private final Map<Integer, h> c;
    private int d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/DocumentTree$Companion;", "", "<init>", "()V", "TAG", "", "MAX_ALLOWED_NODES", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9655a = new a(null);
    }

    public j() {
        h r11 = new h(0, NodeType.VIRTUAL, -1, "", null, null, 0, null, 160, null);
        this.f9656b = r11;
        Map<Integer, h> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r0.put(Integer.valueOf(r11.a()), r11);
        this.c = r0;
        this.d = 1;
    }

    public static /* synthetic */ h a(j r0, NodeType r1, String r2, int r3, Integer r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    private final List<h> a(int r27, NodeType r28, String r29, Integer r30) {
        int r9 = h.f9649a.a(r29);
        int r2 = -1;
        if (r30 == null) goto L7;
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r30, Number.class, "com.obric.memorydata.plugin")).intValue();
        h r4 = (h) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r3)), h.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        r2 = r4.b();
    L7:
        h r14 = new h(r27, NodeType.VIRTUAL, r2 + 1, "", r30, null, r9, null, 160, null);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(a(r29, 512), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r6 = 0;
        Iterator r7 = r1.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Object r8 = r7.next();
        int r10 = r6 + 1;
        if (r6 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        int r12 = this.d;
        this.d = r12 + 1;
        r5.add(new h(r12, NodeType.TEXT, r14.b() + 1, r11, Integer.valueOf(r27), null, h.f9649a.a(r11), null, 160, null));
        r6 = r10;
        goto L9
    L14:
        List r0 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        List<Integer> r13 = r14.e();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L16:
        if (r17.hasNext() == false) goto L18;
        r16.add(Integer.valueOf(((h) ZeusTransformUtils.preCheckCast(r17.next(), h.class, "com.obric.memorydata.plugin")).a()));
        goto L16
    L18:
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r14), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final List<String> a(String r8) {
        boolean r2 = false;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(new Regex("(?<=[.!?。！？])(\\s+|$)").split((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L7:
        boolean r4 = true;
        if (r11.hasNext() == false) goto L15;
        Object r3 = r11.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L13;
        r4 = false;
    L13:
        if (r4 == false) goto L7;
        r1.add(r3);
        goto L7
    L15:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r12.size() <= 1) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L25;
        return r12;
    L25:
        return CollectionsKt.listOf(r8);
    L18:
        if (r8.length() >= 512) goto L20;
        goto L19
    }

    private final List<String> a(String r8, int r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(new Regex("\\n\\n+").split(r10, 0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L24;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (h.f9649a.a(r3) > r9) goto L8;
        List<String> r4 = CollectionsKt.listOf(r3);
    L22:
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        List<String> r5 = a(r3);
        if (r5.size() == 1) goto L11;
    L13:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r6.iterator();
    L15:
        if (r13.hasNext() == false) goto L21;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (h.f9649a.a(r14) > r9) goto L19;
        List<String> r15 = CollectionsKt.listOf(r14);
    L20:
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"));
        goto L15
    L19:
        r15 = b(r14, r9);
        goto L20
    L21:
        r4 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        goto L22
    L11:
        if (Intrinsics.areEqual(r5.get(0), r3) == false) goto L13;
        r4 = b(r3, r9);
        goto L22
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(JsonWriter r0) {
        r0.close();
        return Unit.INSTANCE;
    }

    private final void a(JsonWriter r5, h r6) {
        r5.beginObject();
        r5.name("i").value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r6.a()), Number.class, "com.obric.memorydata.plugin"));
        r5.name("l").value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r6.f()), Number.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.e(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
        r5.name("c").beginArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.memorydata.plugin")).intValue())), h.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        a(r5, r0);
        goto L6
    L10:
        r5.endArray();
    L11:
        r5.endObject();
    }

    private final List<String> b(String r5, int r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        List<String> r1 = new Regex("[,;，、；]").split(r0, 0);
        if (r1.size() <= 1) goto L14;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (h.f9649a.a(r3) > r6) goto L10;
        List<String> r4 = CollectionsKt.listOf(r3);
    L11:
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        goto L6
    L10:
        r4 = c(r3, r6);
        goto L11
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L14:
        return c(r5, r6);
    }

    private final List<String> c(String r11, int r12) {
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L3:
        boolean r2 = true;
        if (r11.length() <= r12) goto L17;
        Integer r0 = Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.b.a(r11, 0, (int) (((double) r12) * 0.7d)), CharSequence.class, "com.obric.memorydata.plugin"), ' ', 0, false, 6, null));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L9;
        r2 = false;
    L9:
        if (r2 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        int r1 = r0.intValue();
    L15:
        r10.add(com.obric.memorydata.utils.b.a(r11, 0, r1));
        r11 = com.obric.memorydata.utils.b.a(r11, r1);
        goto L3
    L14:
        r1 = r12;
        goto L15
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L20;
        r2 = false;
    L20:
        if (r2 == false) goto L22;
        r10.add(r11);
    L22:
        return r10;
    }

    /* JADX INFO: renamed from: lambda$6SAW446ZZ72WT6BPs1teb-h95Ao, reason: not valid java name */
    public static /* synthetic */ Unit m580lambda$6SAW446ZZ72WT6BPs1tebh95Ao(JsonWriter r0) {
        return a(r0);
    }

    public final h a() {
        h r6 = (h) ZeusTransformUtils.preCheckCast(this.c.get(0), h.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DocumentTree", "虚拟根节点未初始化", null, 4, null);
        return null;
    L6:
        return r6;
    }

    public final h a(int r2) {
        return (h) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r2)), h.class, "com.obric.memorydata.plugin");
    }

    public final h a(NodeType r19, String r20, int r21, Integer r22) {
        Intrinsics.checkNotNullParameter(r19, "type");
        Intrinsics.checkNotNullParameter(r20, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (r22 == null) goto L5;
        int r1 = r22.intValue();
    L6:
        int r2 = this.d;
        this.d = r2 + 1;
        if (h.f9649a.a(r20) <= 512) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        List<h> r3 = a(r2, r19, r20, Integer.valueOf(r1));
    L13:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r5.hasNext() == false) goto L22;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5.next(), h.class, "com.obric.memorydata.plugin");
        this.c.put(Integer.valueOf(r6.a()), r6);
        Integer r7 = r6.d();
        if (r7 == null) goto L15;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        h r9 = (h) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r8)), h.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        Map<Integer, h> r10 = this.c;
        Integer r11 = Integer.valueOf(r8);
        List<Integer> r13 = r9.e();
        r13.add(Integer.valueOf(r6.a()));
        Unit r12 = Unit.INSTANCE;
        r10.put(r11, h.a(r9, 0, null, 0, null, null, r13, 0, null, 223, null));
        goto L15
    L22:
        return (h) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3), h.class, "com.obric.memorydata.plugin");
    L12:
        r3 = CollectionsKt.listOf(new h(r2, r19, r21, r20, Integer.valueOf(r1), null, h.f9649a.a(r20), null, 160, null));
        goto L13
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = this.f9656b.a();
        goto L6
    }

    public final List<h> b() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final List<h> c() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin")).a() != this.f9656b.a()) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r1.add(r3);
        goto L3
    L11:
        List<h> r7 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L15;
        r7 = null;
    L15:
        if (r7 == null) goto L17;
        return r7;
    L17:
        return CollectionsKt.emptyList();
    }

    public final String d() {
        if (this.c.size() <= 300000) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DocumentTree", "节点数量超过最大限制: " + this.c.size() + " > 300000", null, 4, null);
        return "";
    L6:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        boolean r5 = false;
        if (r1.hasNext() == false) goto L17;
        Object r4 = r1.next();
        Integer r7 = ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin")).d();
        int r8 = this.f9656b.a();
        if (r7 != null) goto L13;
    L15:
        if (r5 == false) goto L7;
        r3.add(r4);
        goto L7
    L13:
        if (r7.intValue() != r8) goto L15;
        r5 = true;
        goto L15
    L17:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == false) goto L20;
        return "";
    L20:
        StringWriter r6 = new StringWriter();
        final JsonWriter r9 = new JsonWriter((Writer) ZeusTransformUtils.preCheckCast(r6, Writer.class, "com.obric.memorydata.plugin"));
        r9.setLenient(true);
    L32:
        th = move-exception;
        com.obric.memorydata.utils.y.a(null, new $$Lambda$j$6SAW446ZZ72WT6BPs1tebh95Ao(r9), 1, null);
        throw th;
    L22:
        if (r2.size() != 1) goto L24;
        a(r9, (h) ZeusTransformUtils.preCheckCast(r2.get(0), h.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L29:
        String r10 = r6.toString();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");     // Catch: Throwable -> L32
        com.obric.memorydata.utils.y.a(null, new $$Lambda$j$6SAW446ZZ72WT6BPs1tebh95Ao(r9), 1, null);
        return r10;
    L24:
        r9.beginArray();     // Catch: Throwable -> L32
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L32
    L26:
        if (r11.hasNext() == false) goto L28;
        a(r9, (h) ZeusTransformUtils.preCheckCast(r11.next(), h.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
        goto L26
    L28:
        r9.endArray();     // Catch: Throwable -> L32
        goto L29
    }
}
