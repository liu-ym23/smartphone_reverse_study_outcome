package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.serialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolverBase;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolverKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\u00020\u0017*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u000ej\b\u0012\u0004\u0012\u00020\u000b`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/serialization/JvmStringTable;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "nameResolver", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolver;)V", "localNames", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "records", "Ljava/util/ArrayList;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder;", "Lkotlin/collections/ArrayList;", "strings", "getStrings", "()Ljava/util/ArrayList;", "getQualifiedClassNameIndex", "className", "isLocal", "", "getStringIndex", "string", "serializeTo", "", "output", "Ljava/io/OutputStream;", "toNameResolver", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "isTrivial", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmStringTable implements StringTable {
    private final LinkedHashSet<Integer> localNames;
    private final HashMap<String, Integer> map;
    private final ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> records;
    private final ArrayList<String> strings;

    /* JADX WARN: Multi-variable type inference failed */
    public JvmStringTable() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean isTrivial(JvmProtoBuf.StringTableTypes.Record.Builder r5) {
        if (r5.hasPredefinedIndex() == false) goto L5;
    L11:
        return false;
    L5:
        if (r5.hasOperation() == true) goto L11;
        if (r5.getSubstringIndexCount() != 0) goto L11;
        if (r5.getReplaceCharCount() != 0) goto L11;
        return true;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable
    public int getQualifiedClassNameIndex(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "className");
        Integer r5 = this.map.get(r10);
        if (r5 != null) goto L5;
    L8:
        int r12 = this.strings.size();
        if (r11 == false) goto L11;
        this.localNames.add(Integer.valueOf(r12));
    L11:
        JvmProtoBuf.StringTableTypes.Record.Builder r13 = JvmProtoBuf.StringTableTypes.Record.newBuilder();
        if (r11 == false) goto L14;
    L20:
        this.strings.add(r10);
    L21:
        this.records.add(r13);
        this.map.put(r10, Integer.valueOf(r12));
        return r12;
    L14:
        if (StringsKt.f(r10, Typography.dollar) == true) goto L20;
        Integer r14 = JvmNameResolverBase.Companion.getPredefinedStringIndex(r10);
        if (r14 == null) goto L19;
        r13.setPredefinedIndex(r14.intValue());
        this.strings.add("");
        goto L21
    L19:
        r13.setOperation(JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID);
        this.strings.add("L" + StringsKt.E(r10, '.', Typography.dollar) + ';');
        goto L21
    L5:
        if (r11 != this.localNames.contains(r5)) goto L8;
        return r5.intValue();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable
    public int getStringIndex(String r5) {
        Intrinsics.checkNotNullParameter(r5, "string");
        HashMap<String, Integer> r10 = this.map;
        Integer r11 = r10.get(r5);
        if (r11 != null) goto L12;
        int r12 = this.strings.size();
        this.strings.add(r5);
        JvmProtoBuf.StringTableTypes.Record.Builder r13 = (JvmProtoBuf.StringTableTypes.Record.Builder) CollectionsKt.lastOrNull(this.records);
        if (r13 != null) goto L7;
    L9:
        this.records.add(JvmProtoBuf.StringTableTypes.Record.newBuilder());
    L10:
        r11 = Integer.valueOf(r12);
        r10.put(r5, r11);
        goto L12
    L7:
        if (isTrivial(r13) == false) goto L9;
        r13.setRange(r13.getRange() + 1);
    L12:
        return r11.intValue();
    }

    public final ArrayList<String> getStrings() {
        return this.strings;
    }

    public final void serializeTo(OutputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "output");
        JvmProtoBuf.StringTableTypes.Builder r10 = JvmProtoBuf.StringTableTypes.newBuilder();
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> r11 = this.records;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((JvmProtoBuf.StringTableTypes.Record.Builder) r13.next()).build());
        goto L4
    L6:
        r10.addAllRecord(r12);
        r10.addAllLocalName(this.localNames);
        r10.build().writeDelimitedTo(r5);
    }

    public final NameResolver toNameResolver() {
        Object[] r5 = this.strings.toArray(new String[0]);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] r10 = (String[]) r5;
        LinkedHashSet<Integer> r11 = this.localNames;
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> r12 = this.records;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13.add(((JvmProtoBuf.StringTableTypes.Record.Builder) r14.next()).build());
        goto L4
    L7:
        return new JvmNameResolverBase(r10, r11, JvmNameResolverKt.toExpandedRecordsList(r13));
    }

    public JvmStringTable(JvmNameResolver r10) {
        ArrayList<String> r5 = new ArrayList();
        this.strings = r5;
        ArrayList<JvmProtoBuf.StringTableTypes.Record.Builder> r11 = new ArrayList();
        this.records = r11;
        this.map = new HashMap();
        this.localNames = new LinkedHashSet();
        if (r10 == null) goto L15;
        CollectionsKt.c(r5, r10.getStrings());
        Iterator<T> r12 = r10.getTypes().getRecordList().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.add(((JvmProtoBuf.StringTableTypes.Record) r12.next()).toBuilder());
        goto L6
    L8:
        int r13 = this.strings.size();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L11;
        Integer r15 = Integer.valueOf(r14);
        this.map.put(r10.getString(r14), r15);
        r14 = r14 + 1;
        goto L9
    L11:
        this.localNames.addAll(r10.getTypes().getLocalNameList());
        return;
    }

    public /* synthetic */ JvmStringTable(JvmNameResolver r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
