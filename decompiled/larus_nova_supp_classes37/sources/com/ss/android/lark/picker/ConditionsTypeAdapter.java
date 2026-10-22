package com.ss.android.lark.picker;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.Condition;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/ConditionsTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "<init>", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ConditionsTypeAdapter extends TypeAdapter<List<? extends Condition.Element<?>>> {
    public static final ConditionsTypeAdapter INSTANCE = null;

    static {
        INSTANCE = new ConditionsTypeAdapter();
    }

    private ConditionsTypeAdapter() {
    }

    /* JADX INFO: renamed from: read, reason: collision with other method in class */
    public List<Condition.Element<?>> m3316read(JsonReader r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return CollectionsKt.emptyList();
    }

    public /* bridge */ /* synthetic */ Object read(JsonReader r1) {
        return m3316read(r1);
    }

    public void write(JsonWriter r5, List<? extends Condition.Element<?>> r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r6, "value");
        r5.beginArray();
        Iterator<? extends Condition.Element<?>> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Condition.Element<?> r1 = r7.next();
        if (r1 == null) goto L7;
        r5.beginObject();
        r5.name("type").value(r1.getClass().getName());
        r5.name("value");
        GsonProtectorUtils.toJson(ConfigSerializationKt.access$getGson(), r1, r1.getClass(), r5);
        r5.endObject();
        goto L4
    L7:
        r5.nullValue();
        goto L4
    L9:
        r5.endArray();
    }

    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) {
        write(r1, (List) r2);
    }
}
