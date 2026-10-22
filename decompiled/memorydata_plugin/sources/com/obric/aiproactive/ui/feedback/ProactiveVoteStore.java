package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "", "<init>", "()V", "map", "", "", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore$Vote;", "cleared", "", "get", "inspirationId", "set", "", "vote", "clear", "isCleared", "", "Vote", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveVoteStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Vote> f6646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6647b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore$Vote;", "", "<init>", "(Ljava/lang/String;I)V", "LIKE", "DISLIKE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Vote extends Enum<Vote> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Vote[] $VALUES = null;
        public static final Vote DISLIKE = null;
        public static final Vote LIKE = null;

        private static final /* synthetic */ Vote[] $values() {
            return new Vote[]{LIKE, DISLIKE};
        }

        static {
            LIKE = new Vote("LIKE", 0);
            DISLIKE = new Vote("DISLIKE", 1);
            Vote[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Vote(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Vote> getEntries() {
            return $ENTRIES;
        }

        public static Vote valueOf(String r2) {
            return (Vote) ZeusTransformUtils.preCheckCast(Enum.valueOf(Vote.class, r2), Vote.class, "com.obric.memorydata.plugin");
        }

        public static Vote[] values() {
            return (Vote[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Vote[].class, "com.obric.memorydata.plugin");
        }
    }

    public ProactiveVoteStore() {
        this.f6646a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.f6647b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public final Vote a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        return (Vote) ZeusTransformUtils.preCheckCast(this.f6646a.get(r2), Vote.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r2, Vote r3) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        Intrinsics.checkNotNullParameter(r3, "vote");
        this.f6646a.put(r2, r3);
        this.f6647b.remove(r2);
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        this.f6646a.remove(r2);
        this.f6647b.add(r2);
    }

    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        return this.f6647b.contains(r2);
    }
}
