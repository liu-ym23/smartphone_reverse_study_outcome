package com.obric.memorydata.database.manager;

import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/manager/StringSetConverter;", "", "<init>", "()V", "setToString", "", "set", "", "stringToSet", "json", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9604a = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    static {
        f9604a = new w();
    }

    private w() {
    }

    @JvmStatic
    public static final String a(Set<String> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L8:
        return GsonUtil.INSTANCE.toJson(r3);
    }

    @JvmStatic
    public static final Set<String> a(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L28:
        HashSet r6 = new HashSet();
    L27:
        return (Set) ZeusTransformUtils.preCheckCast(r6, Set.class, "com.obric.memorydata.plugin");
    L11:
        if (Intrinsics.areEqual(r5, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) == true) goto L28;
        GsonUtil r3 = GsonUtil.INSTANCE;
        List r4 = null;
        if (r5 != null) goto L16;
    L23:
        if (r4 != null) goto L25;
        r4 = CollectionsKt.emptyList();
    L25:
        r6 = new HashSet((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
        goto L27
    L16:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        r2 = true;
    L18:
        if (r2 == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
        r4 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r5, new a().getType()), List.class, "com.obric.memorydata.plugin");
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
