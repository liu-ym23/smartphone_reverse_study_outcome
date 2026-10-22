package com.larus.bmhome.chat.manager;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PromptCacheManager {
    public static final Gson a = null;
    public static final Keva b = null;
    public static final int c = 0;
    public static boolean d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/manager/PromptCacheManager$CachePrompt;", "", "time", "", "topics", "", "", "<init>", "(JLjava/util/List;)V", "getTime", "()J", "getTopics", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a {

        @SerializedName("time")
        private final long time;

        @SerializedName("topics")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<String> topics;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.time == r9.time) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.topics, r9.topics) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.time;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            List<String> r2 = this.topics;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "CachePrompt(time=" + this.time + ", topics=" + this.topics + ')';
        }

        public a() {
            this(0, new ArrayList());
        }

        public final long a() {
            return this.time;
        }

        public final List<String> b() {
            return this.topics;
        }

        public a(long r1, List<String> r3) {
            this.time = r1;
            this.topics = r3;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((a) r4).a()), Long.valueOf(((a) r3).a()));
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/manager/PromptCacheManager$cacheUnClickedPromptTopic$prompts$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/manager/PromptCacheManager$CachePrompt;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<List<? extends a>> {
        public c() {
        }
    }

    static {
        a = new Gson();
        b = Keva.getRepo("prompt_cache");
        c = z2.a.promptCacheMaxSize();
        new String[]{"#E5FFE7", "#E5FFFA", "#E5F5FF", "#EEEBFF", "#FFEBF1", "#FFF0DB", "#FFFECC"};
        new String[]{"#415841", "#415854", "#414F58", "#454158", "#584149", "#5C4F3D", "#605F39"};
    }

    public static String c() {
        return "key_cached_prompt_".concat(AccountService.a.getSecUserId());
    }

    public static void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        if (d == false) goto L5;
        return;
    L5:
        d = true;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PromptCacheManager$fetchSuggestCard$1(r7, null), 3, null);
    }

    public static void a(Long r13, List r14) {
        Intrinsics.checkNotNullParameter(r14, "topics");
        if (r13 == null) goto L102;
        r13.longValue();
        String r0 = c();
        Keva r1 = b;
        String r2 = r1.getString(r0, "");
        ArrayList r3 = new ArrayList();
        if (r2 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L83;
        r3.add(new a(r13.longValue(), CollectionsKt.toMutableList(r14)));
        r1.storeString(r0, GsonProtectorUtils.toJson(a, r3));
        return;
    L83:
        List r4 = (List) GsonProtectorUtils.fromJson(a, r2, new c().getType());     // Catch: JsonSyntaxException -> L15
    L16:
        Iterator r5 = r3.iterator();
        int r7 = 0;
    L18:
        if (r5.hasNext() == false) goto L26;
        if (((a) r5.next()).a() != r13.longValue()) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L27;
        r7 = r7 + 1;
    L27:
        if (r7 <= (-1)) goto L46;
        List<String> r9 = ((a) ListProtector.get(r3, r7)).b();
        if (r9 == null) goto L42;
        List<String> r10 = r9;
        if ((r10 instanceof Collection) == true) goto L33;
    L35:
        Iterator<T> r11 = r10.iterator();
    L37:
        if (r11.hasNext() == false) goto L41;
        if (((ArrayList) r14).contains((String) r11.next()) == true) goto L37;
    L41:
        boolean r12 = true;
    L43:
        if (r12 == false) goto L45;
        return;
    L45:
        ListProtector.remove(r3, r7);
        ListProtector.add(r3, r7, new a(r13.longValue(), CollectionsKt.toMutableList(r14)));
    L48:
        if (r3.size() <= 1) goto L50;
        CollectionsKt.sortWith(r3, new b());
    L50:
        final LinkedHashSet r15 = new LinkedHashSet();
        Iterator r16 = r3.iterator();
        int r17 = 0;
    L52:
        if (r16.hasNext() == false) goto L63;
        a r18 = (a) r16.next();
        List<String> r19 = r18.b();
        if (r19 == null) goto L56;
        CollectionsKt.removeAll(r19, new n0(r15));
    L56:
        List<String> r20 = r18.b();
        if (r20 == null) goto L59;
        int r21 = r20.size();
    L60:
        r17 = r17 + r21;
        List<String> r22 = r18.b();
        if (r22 == null) goto L52;
        r15.addAll(r22);
        goto L52
    L59:
        r21 = 0;
        goto L60
    L63:
        int r110 = c;
        if (r17 <= r110) goto L81;
        int r23 = r17 - r110;
        int r111 = r3.size() - 1;
        int r112 = 0;
    L66:
        if (r112 >= r23) goto L81;
        if (r111 < 0) goto L81;
        List<String> r24 = ((a) ListProtector.get(r3, r111)).b();
        if (r24 != null) goto L71;
    L74:
        boolean r25 = true;
    L75:
        if (r25 == false) goto L76;
        r111 = r111 - 1;
        goto L66
    L76:
        List<String> r26 = ((a) ListProtector.get(r3, r111)).b();
        if (r26 == null) goto L79;
        String r27 = (String) CollectionsKt.removeFirstOrNull(r26);
    L79:
        r112 = r112 + 1;
        goto L66
    L71:
        if (r24.isEmpty() == true) goto L74;
        r25 = false;
    L81:
        CollectionsKt.removeAll(r3, new o0());
        b.storeString(r0, GsonProtectorUtils.toJson(a, r3));
        return;
    L33:
        if (r10.isEmpty() == false) goto L35;
    L42:
        r12 = false;
        goto L43
    L46:
        Intrinsics.checkNotNull(r4);
        r3.addAll(r4);
        r3.add(new a(r13.longValue(), CollectionsKt.toMutableList(r14)));
        goto L48
    L22:
        r8 = false;
        goto L23
    L26:
        r7 = -1;
    L15:
        r4 = CollectionsKt.emptyList();
        goto L16
    L7:
        if (r2.length() == 0) goto L10;
        r6 = false;
        goto L11
    }
}
