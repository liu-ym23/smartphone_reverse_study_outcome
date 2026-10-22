package com.larus.avlink.e.mock.scenario;

import com.larus.avlink.e.mock.CameraCallbackRecord;
import com.larus.avlink.e.mock.h;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006,"}, d2 = {"Lcom/larus/avlink/e/mock/scenario/Scenario;", "", "name", "", "description", "callbacks", "", "Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "parameterMapping", "", "timingStrategy", "Lcom/larus/avlink/e/mock/scenario/TimingStrategy;", "tags", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/larus/avlink/e/mock/scenario/TimingStrategy;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getDescription", "getCallbacks", "()Ljava/util/List;", "getParameterMapping", "()Ljava/util/Map;", "getTimingStrategy", "()Lcom/larus/avlink/e/mock/scenario/TimingStrategy;", "getTags", "describe", "toJson", "hasTag", "", "tag", "summary", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Scenario {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final List<CameraCallbackRecord> callbacks;
    private final String description;
    private final String name;
    private final Map<String, Object> parameterMapping;
    private final List<String> tags;
    private final TimingStrategy timingStrategy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Scenario copy$default(Scenario r4, String r5, String r6, List r7, Map r8, TimingStrategy r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.name;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.description;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.callbacks;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.parameterMapping;
    L14:
        Map r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.timingStrategy;
    L17:
        TimingStrategy r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.tags;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.description;
    }

    public final List<CameraCallbackRecord> component3() {
        return this.callbacks;
    }

    public final Map<String, Object> component4() {
        return this.parameterMapping;
    }

    public final TimingStrategy component5() {
        return this.timingStrategy;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final Scenario copy(String r9, String r10, List<CameraCallbackRecord> r11, Map<String, ? extends Object> r12, TimingStrategy r13, List<String> r14) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "description");
        Intrinsics.checkNotNullParameter(r11, "callbacks");
        Intrinsics.checkNotNullParameter(r12, "parameterMapping");
        Intrinsics.checkNotNullParameter(r13, "timingStrategy");
        Intrinsics.checkNotNullParameter(r14, "tags");
        return new Scenario(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Scenario) == true) goto L8;
        return false;
    L8:
        Scenario r6 = (Scenario) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbacks, r6.callbacks) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parameterMapping, r6.parameterMapping) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timingStrategy, r6.timingStrategy) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.callbacks.hashCode()) * 31) + this.parameterMapping.hashCode()) * 31) + this.timingStrategy.hashCode()) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "Scenario(name=" + this.name + ", description=" + this.description + ", callbacks=" + this.callbacks + ", parameterMapping=" + this.parameterMapping + ", timingStrategy=" + this.timingStrategy + ", tags=" + this.tags + ')';
    }

    public final String describe() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Scenario: " + this.name);
        r0.append('\n');
        r0.append("  Description: " + this.description);
        r0.append('\n');
        StringBuilder r2 = new StringBuilder("  Callbacks: ");
        r2.append(this.callbacks.size());
        r2.append(" (");
        List<CameraCallbackRecord> r3 = this.callbacks;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(((CameraCallbackRecord) r5.next()).getCallbackType());
        goto L4
    L6:
        r2.append(CollectionsKt.joinToString$default(r4, ", ", null, null, 0, null, null, 62, null));
        r2.append(')');
        r0.append(r2.toString());
        r0.append('\n');
        if ((!this.parameterMapping.isEmpty()) == false) goto L9;
        r0.append("  Parameter Mapping: " + this.parameterMapping);
        r0.append('\n');
    L9:
        r0.append("  Timing Strategy: " + this.timingStrategy);
        r0.append('\n');
        if ((!this.tags.isEmpty()) == false) goto L13;
        r0.append("  Tags: " + CollectionsKt.joinToString$default(this.tags, ", ", null, null, 0, null, null, 62, null));
        r0.append('\n');
    L13:
        return r0.toString();
    }

    public final String summary() {
        return "Scenario(" + this.name + ", " + this.callbacks.size() + " callbacks, " + this.timingStrategy + ')';
    }

    public final String toJson() {
        return h.e(this);
    }

    public final List<CameraCallbackRecord> getCallbacks() {
        return this.callbacks;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParameterMapping() {
        return this.parameterMapping;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final TimingStrategy getTimingStrategy() {
        return this.timingStrategy;
    }

    public final boolean hasTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.tags.contains(r2);
    }

    public Scenario(String r2, String r3, List<CameraCallbackRecord> r4, Map<String, ? extends Object> r5, TimingStrategy r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "callbacks");
        Intrinsics.checkNotNullParameter(r5, "parameterMapping");
        Intrinsics.checkNotNullParameter(r6, "timingStrategy");
        Intrinsics.checkNotNullParameter(r7, "tags");
        this.name = r2;
        this.description = r3;
        this.callbacks = r4;
        this.parameterMapping = r5;
        this.timingStrategy = r6;
        this.tags = r7;
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
        if ((!r4.isEmpty()) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("场景必须包含至少一个回调".toString());
    L10:
        throw new IllegalArgumentException("场景名称不能为空".toString());
    }

    public /* synthetic */ Scenario(String r8, String r9, List r10, Map r11, TimingStrategy r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = "";
    L5:
        String r2 = r9;
        if ((r14 & 8) == 0) goto L8;
        r11 = MapsKt.emptyMap();
    L8:
        Map r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = TimingStrategy.c.a;
    L11:
        TimingStrategy r5 = r12;
        if ((r14 & 32) == 0) goto L14;
        r13 = CollectionsKt.emptyList();
    L14:
        this(r8, r2, r10, r4, r5, r13);
    }
}
