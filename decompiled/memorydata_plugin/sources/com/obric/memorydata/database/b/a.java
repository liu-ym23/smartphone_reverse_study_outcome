package com.obric.memorydata.database.b;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/converter/IntListConverter;", "", "<init>", "()V", "fromIntList", "", EventBody.KEY_VALUE, "", "", "toIntList", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: com.obric.memorydata.database.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/database/converter/IntListConverter$toIntList$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0453a extends TypeToken<List<? extends Integer>> {
        C0453a() {
        }
    }

    public a() {
    }

    public final String a(List<Integer> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return new Gson().toJson(r1);
    }

    public final List<Integer> a(String r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        Type r5 = new C0453a().getType();     // Catch: Exception -> L16
        List<Integer> r6 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r3, r5), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if (r6 != null) goto L20;
        return CollectionsKt.emptyList();
    L20:
        return r6;
    L17:
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
    }
}
