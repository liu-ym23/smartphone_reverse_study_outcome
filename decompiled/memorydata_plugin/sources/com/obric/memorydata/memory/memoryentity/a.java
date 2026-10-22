package com.obric.memorydata.memory.memoryentity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0005J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/ChatMessageUtil;", "", "<init>", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "fromJsonToList", "", "Lcom/obric/memorydata/memory/memoryentity/ChatMessage;", "jsonString", "toJsonString", "chatMessages", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f10309b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0507a extends TypeToken<List<? extends ChatMessage>> {
        public C0507a() {
        }
    }

    static {
        f10308a = new a();
        f10309b = new Gson();
    }

    private a() {
    }

    public final String a(List<ChatMessage> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "chatMessages");
        String r8 = f10309b.toJson(r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ChatMessageUtil", "Failed to convert ChatMessage list to JSON: " + e, null, 4, null);
        return "";
    }

    public final List<ChatMessage> a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "jsonString");
        GsonUtil r0 = GsonUtil.INSTANCE;     // Catch: JsonSyntaxException -> L23
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        boolean r1 = true;
    L7:
        List r2 = null;
        if (r1 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r7, new C0507a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L23
    L13:
        if (r2 == null) goto L33;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L23
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L23
        Iterator r9 = r8.iterator();     // Catch: JsonSyntaxException -> L23
    L16:
        if (r9.hasNext() == false) goto L32;
        Object r4 = r9.next();     // Catch: JsonSyntaxException -> L23
        if (((ChatMessage) ZeusTransformUtils.preCheckCast(r4, ChatMessage.class, "com.obric.memorydata.plugin")).isValid() == false) goto L16;
        r3.add(r4);     // Catch: JsonSyntaxException -> L23
        goto L16
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L33:
        return CollectionsKt.emptyList();
    L6:
        r1 = false;
    L23:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ChatMessageUtil", "Failed to parse JSON to ChatMessage list: " + e, null, 4, null);
        return CollectionsKt.emptyList();
    }
}
